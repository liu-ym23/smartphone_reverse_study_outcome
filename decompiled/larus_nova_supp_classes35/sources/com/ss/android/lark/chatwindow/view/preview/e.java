package com.ss.android.lark.chatwindow.view.preview;

import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.PreviewVideo;
import com.ss.android.lark.statistics.video_site.VideoSiteHitPoint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ MessageUrlPreview b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;

    public e(d r1, MessageUrlPreview r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
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
    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        d r5 = this.a;
        MessageUrlPreview r0 = this.b;
        boolean r1 = this.c;
        r5.getClass();
        if (r1 == false) goto L8;
        PreviewVideo r6 = r0.getPreviewVideo();
        if (r6 == null) goto L8;
        VideoSiteHitPoint.b(r6.getSite());
    L8:
        if (TextUtils.isEmpty(this.d) == true) goto L11;
        d r7 = this.a;
        r7.f.auditLinkEvent(r7.c.b(), this.d);
        ChatCoreModule.a().getPerfEnterChatMonitor().t();
        d r8 = this.a;
        r8.e.c(r8.a, this.d, r8.c.isGroup() ? 1 : 0);
        return;
    }
}
