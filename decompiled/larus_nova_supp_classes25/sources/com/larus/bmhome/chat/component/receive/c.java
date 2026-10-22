package com.larus.bmhome.chat.component.receive;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.DragEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements View.OnDragListener {
    public final Fragment a;
    public final Function1<String, Unit> b;
    public final Function1<List<? extends Uri>, Unit> c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View r17, DragEvent r18) {
        if (r18 == null) goto L5;
        Integer r3 = Integer.valueOf(r18.getAction());
    L6:
        boolean r5 = false;
        String r7 = "";
        if (r3 != null) goto L10;
    L49:
        if (r3 != null) goto L52;
    L107:
        return true;
    L52:
        if (r3.intValue() != 3) goto L107;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L100
        ClipData r6 = r18.getClipData();     // Catch: Throwable -> L100
        if (r6 == null) goto L56;
        int r8 = r6.getItemCount();     // Catch: Throwable -> L100
    L57:
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L100
        int r10 = 0;
    L58:
        if (r10 >= r8) goto L83;
        ClipData.Item r11 = r18.getClipData().getItemAt(r10);     // Catch: Throwable -> L100
        CharSequence r12 = r11.getText();     // Catch: Throwable -> L100
        if (r12 != null) goto L62;
        r12 = r11.getHtmlText();     // Catch: Throwable -> L100
    L62:
        Uri r13 = r11.getUri();     // Catch: Throwable -> L100
        if (r12 != null) goto L65;
    L68:
        boolean r14 = true;
    L69:
        if (r14 == false) goto L71;
        if (r13 == null) goto L81;
        r9.add(r13);     // Catch: Throwable -> L100
    L81:
        r10 = r10 + 1;     // Catch: Throwable -> L100
        goto L58
    L71:
        if (r7.length() <= 0) goto L73;
        boolean r15 = true;
    L74:
        if (r15 == true) goto L76;
    L78:
        r7 = r7 + r12;     // Catch: Throwable -> L100
        goto L81
    L76:
        if (StringsKt.startsWith$default(r12, "\n", false, 2, null) == true) goto L78;
        r7 = r7 + '\n';     // Catch: Throwable -> L100
        goto L78
    L73:
        r15 = false;
        goto L74
    L65:
        if (r12.length() == 0) goto L68;
        r14 = false;
        goto L69
    L83:
        if (r7.length() <= 0) goto L85;
        r5 = true;
    L85:
        if (r5 == false) goto L89;
        this.b.invoke(r7);     // Catch: Throwable -> L100
    L96:
        FLogger.a.i("ChatDragSendListener", "handleDropContent, texts:" + r7 + ",uris:" + r9);     // Catch: Throwable -> L98
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L98
    L103:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L107;
        FLogger.a.e("ChatDragSendListener", "handleDropContent failed:" + r1);
    L98:
        th = th;
    L102:
        Result.Companion r2 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L103
    L89:
        if ((!r9.isEmpty()) == false) goto L96;
        if (Build.VERSION.SDK_INT < 24) goto L95;
        FragmentActivity r16 = this.a.getActivity();     // Catch: Throwable -> L98
        if (r16 == null) goto L95;
        r16.requestDragAndDropPermissions(r18);     // Catch: Throwable -> L98
    L95:
        this.c.invoke(r9);     // Catch: Throwable -> L98
        goto L96
    L56:
        r8 = 0;
    L100:
        th = th;
        goto L102
    L10:
        if (r3.intValue() != 1) goto L49;
        ICoreInputAbility r19 = (ICoreInputAbility) this.d.getValue();
        if (r19 == null) goto L14;
        boolean r20 = r19.Qd(false);
    L15:
        ICoreInputAbility r21 = (ICoreInputAbility) this.d.getValue();
        if (r21 == null) goto L18;
        boolean r22 = r21.CD(false);
    L19:
        ClipDescription r110 = r18.getClipDescription();
        if (r110 == null) goto L22;
        int r111 = r110.getMimeTypeCount();
    L23:
        int r112 = 0;
        boolean r113 = false;
        boolean r114 = false;
        boolean r115 = false;
    L24:
        if (r112 >= r111) goto L40;
        ClipDescription r116 = r18.getClipDescription();
        if (r116 == null) goto L29;
        String r117 = r116.getMimeType(r112);
        if (r117 == null) goto L29;
    L31:
        if (StringsKt.startsWith$default(r117, "text/", false, 2, null) == false) goto L34;
        r113 = true;
    L39:
        r112 = r112 + 1;
        goto L24
    L34:
        if (StringsKt.startsWith$default(r117, "image/", false, 2, null) == false) goto L37;
        r114 = true;
        goto L39
    L37:
        if (StringsKt.startsWith$default(r117, "application/", false, 2, null) == false) goto L39;
        r115 = true;
    L29:
        r117 = "";
        goto L31
    L40:
        FLogger.a.i("ChatDragSendListener", "isInterruptDragStart, hasText:" + r113 + ",hasImage:" + r114 + ",hasFile:" + r115);
        if (r113 == true) goto L107;
        if (r20 == false) goto L44;
        if (r114 == true) goto L107;
    L44:
        if (r22 == false) goto L47;
        if (r115 == true) goto L107;
    L47:
        return false;
    L22:
        r111 = 0;
        goto L23
    L18:
        r22 = false;
        goto L19
    L14:
        r20 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    public c(Fragment r2, s r3, t r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "sendTexts");
        Intrinsics.checkNotNullParameter(r4, "sendUris");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new b(this));
    }
}
