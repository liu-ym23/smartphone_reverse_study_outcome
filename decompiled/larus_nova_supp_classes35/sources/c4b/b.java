package c4b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initData");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Context r0 = r5.getContext();
        View r6 = r5.getContentView();
        if (DevEnvUtil.isDevelopPackage(r0) == false) goto L5;
    L6:
        TextView r1 = new TextView(r0);
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-2, -2);
        r2.addRule(10);
        r2.addRule(20);
        r2.topMargin = UIUtils.getScreenHeight(r0) / 4;
        r1.setLayoutParams(r2);
        r1.setText("CORE");
        r1.setTextSize(2, 12.0f);
        r1.setTextColor(1073741824);
        int r3 = UIUtils.dp2px(r0, 8.0f);
        r1.setPadding(r3, r3, r3, r3);
        if ((r6 instanceof ViewGroup) == false) goto L9;
        ViewGroup r7 = (ViewGroup) r6;
    L10:
        if (r7 == null) goto L14;
        r7.addView(r1);
        return;
    L14:
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        if (DevEnvUtil.isDebugMode(r0) == true) goto L6;
    }
}
