package com.bytedance.android.annie.debug.ui;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UrlFormDialog extends Dialog {
    public final Context a;
    public final Uri b;
    public View c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        View r11 = LayoutInflater.from(getContext()).inflate(2131558544, null, false);
        this.c = r11;
        if (r11 == null) goto L40;
        setContentView(r11);
        Window r12 = getWindow();
        if (r12 == null) goto L7;
        r12.setLayout(-1, -2);
    L7:
        TextView r13 = (TextView) this.d.getValue();
        if (r13 == null) goto L11;
        r13.setText(String.valueOf(this.b.getScheme()));
    L11:
        TextView r14 = (TextView) this.e.getValue();
        if (r14 == null) goto L15;
        r14.setText(this.b.getHost() + this.b.getPath());
    L15:
        Set r15 = UriProtector.getQueryParameterNames(this.b);
        ArrayList r0 = new ArrayList();
        Iterator r16 = r15.iterator();
    L17:
        if (r16.hasNext() == false) goto L25;
        String r17 = (String) r16.next();
        g r18 = new g();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r18.c = r17;
        String r19 = String.valueOf(UriProtector.getQueryParameter(this.b, r17));
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.d = r19;
        if (StringsKt.contains$default(r17, com.bytedance.android.ec.core.event.a.KEY_URL, false, 2, null) == false) goto L23;
        if (UriProtector.parse(r18.d) == null) goto L23;
        r18.a = 1;
        Uri r20 = UriProtector.parse(r18.d);
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r18.b = r20;
    L23:
        r0.add(r18);
        goto L17
    L25:
        if (r0.size() <= 1) goto L27;
        CollectionsKt.sortWith(r0, new h());
    L27:
        UrlFormAdapter r110 = new UrlFormAdapter(r0, this.a);
        RecyclerView r1 = (RecyclerView) this.f.getValue();
        if (r1 == null) goto L31;
        r1.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    L31:
        RecyclerView r21 = (RecyclerView) this.f.getValue();
        if (r21 == null) goto L41;
        r21.setAdapter(r110);
        return;
    L41:
        return;
    }

    public UrlFormDialog(Context r10, Uri r11) {
        Intrinsics.checkNotNullParameter(r10, "mContext");
        Intrinsics.checkNotNullParameter(r11, "uri");
        super(r10, 2131954078);
        this.a = r10;
        this.b = r11;
        this.d = LazyKt.lazy(new UrlFormDialog$annieDebugUrlDialogScheme$2(this));
        this.e = LazyKt.lazy(new UrlFormDialog$annieDebugUrlDialogPath$2(this));
        this.f = LazyKt.lazy(new UrlFormDialog$annieDebugUrlDialogParams$2(this));
    }
}
