package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.graphics.Paint;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.bmhome.chat.layout.widget.MessageLoading;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h4 extends k {
    public final MessageLoading r;
    public int s;

    public static final class a {
        public static int a(Context r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            if (r6 == false) goto L5;
            Paint r7 = new Paint();
            r7.setAntiAlias(true);
            r7.setTextSize(we8.a.a(i5.o(), true));
            Paint.FontMetrics r8 = r7.getFontMetrics();
            return ((int) ((r8.descent - r8.ascent) * 1.1f)) + (r5.getResources().getDimensionPixelSize(2131167562) * 2);
        L5:
            float r9 = we8.a.a(r5.getResources().getDimensionPixelSize(v19.c.b(2130972275, null, 2131167620)), false);
            Paint r2 = new Paint();
            r2.setAntiAlias(true);
            r2.setTextSize(r9);
            Paint.FontMetrics r10 = r2.getFontMetrics();
            return Math.max(r5.getResources().getDimensionPixelSize(v19.c.b(2130971299, r5, 2131166968)), (int) Math.ceil(r10.bottom - r10.top)) + (r5.getResources().getDimensionPixelSize(2131167562) * 2);
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.s;
    }

    public final MessageLoading getLoadingView() {
        return this.r;
    }

    public h4(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        MessageLoading r0 = new MessageLoading(r8);
        int r9 = getResources().getDimensionPixelSize(2131167561);
        int r1 = getResources().getDimensionPixelSize(2131167561);
        int r2 = getResources().getDimensionPixelSize(2131167562);
        int r3 = getResources().getDimensionPixelSize(2131167562);
        FLogger.a.i("updatePaddingRelative", "view:" + r0.getClass().getSimpleName() + ",source:,start:" + r9 + ",top:" + r2 + ",end:" + r1 + ",bottom:" + r3);
        r0.setPaddingRelative(r9, r2, r1, r3);
        addView(r0, new LinearLayout.LayoutParams(-2, -2));
        this.r = r0;
        this.s = super.getBoxType();
    }

    @Override // com.larus.bmhome.chat.layout.item.k
    public final void o(int r2) {
        super.o(r2);
        Integer r3 = getCurrentLoadingProgress();
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
        this.r.setProgress(r4);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r5) {
        super.setBoxType(r5);
        this.s = r5;
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L18;
        IFlowThemeConfigProvider r6 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r6 == null) goto L15;
        int r7 = Integer.valueOf(r6.a(ContextCompat.getColor(getContext(), 2131103298), ThemeColorKey.MESSAGE_SEND_TEXT_LOADING_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_TEXT_LOADING)).intValue();
        this.r.setColor(r7);
        return;
    L15:
        return;
    L18:
        return;
    L11:
        if (getImmerseBgColor() == null) goto L13;
        this.r.setColor(ContextCompat.getColor(getContext(), 2131103298));
        return;
    L13:
        this.r.setColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.bmhome.chat.layout.item.k
    public final void n(Message r4, boolean r5) {
        JSONObject r0 = null;
        this.r.setOnClickListener(null);
        if (r4 == null) goto L5;
        String r6 = ap8.a.b(r4);
    L6:
        String r2 = "";
        if (Intrinsics.areEqual(r6, "avatar_image") == true) goto L34;
        if (r4 != null) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L30;
        r2 = this.r.getContext().getString(2131906835);
        Intrinsics.checkNotNull(r2);
    L30:
        this.r.setProgressVisible(true);
        this.r.setLoadingText(r2);
        Integer r8 = getCurrentLoadingProgress();
        if (r8 == null) goto L36;
        this.r.setProgress(r8.intValue());
        return;
    L36:
        return;
    L25:
        if (r4.getContentType() != 6) goto L27;
        r7 = true;
        goto L28
    L34:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L17
        String r10 = r4.getContent();     // Catch: Throwable -> L17
        if (r10 == null) goto L11;
        r0 = new JSONObject(r10);     // Catch: Throwable -> L17
    L11:
        if (r0 == null) goto L14;
        String r11 = JSONObjectProtectorUtils.getString(r0, ChatDraftItem.TYPE_TEXT);     // Catch: Throwable -> L17
        if (r11 == null) goto L14;
    L15:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L17
    L19:
        Object r3 = r2;
        if (Result.exceptionOrNull-impl(r12) != null) goto L22;
        r3 = r12;
    L22:
        r2 = (String) r3;
    L14:
        r11 = "";
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L5:
        r6 = null;
        goto L6
    }
}
