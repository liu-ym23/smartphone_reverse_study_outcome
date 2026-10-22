package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import fa2.a;
import ha2.b;
import ha2.c;
import ha2.d;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/PSSelectedMessageDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSSelectedMessageDialog extends AppCompatDialog {
    public TextView a;
    public TextView b;
    public TextView c;
    public final DataCenter d;
    public final CompositeDisposable e;
    public final a f;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setGravity(80);
    L5:
        setContentView(2131566778);
        Window r5 = getWindow();
        if (r5 == null) goto L8;
        r5.setLayout(-1, -2);
    L8:
        this.a = (TextView) findViewById(2131380366);
        this.b = (TextView) findViewById(2131367004);
        this.c = (TextView) findViewById(2131365114);
        TextView r6 = this.a;
        if (r6 == null) goto L11;
        r6.setOnClickListener(new b(this));
    L11:
        TextView r7 = this.b;
        if (r7 == null) goto L14;
        r7.setOnClickListener(new c(this));
    L14:
        TextView r8 = this.c;
        if (r8 == null) goto L17;
        r8.setOnClickListener(new d(this));
    L17:
        TextView r9 = this.a;
        if (r9 == null) goto L20;
        r9.setText(2131922414);
    L20:
        TextView r10 = this.b;
        if (r10 == null) goto L24;
        r10.setText(2131915838);
        return;
    }

    public PSSelectedMessageDialog(Context r2, DataCenter r3, CompositeDisposable r4, a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "cd");
        Intrinsics.checkNotNullParameter(r5, "selectedDataSource");
        if (SelectedMsgABHelper.b().useAppcompactStyle == false) goto L5;
        int r0 = 2131954640;
    L6:
        super(r2, r0);
        this.d = r3;
        this.e = r4;
        this.f = r5;
        return;
    L5:
        r0 = 2131954639;
        goto L6
    }
}
