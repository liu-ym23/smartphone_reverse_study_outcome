package com.bytedance.android.live.liveinteract.animation;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ o a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.m b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ EPointF e;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.j f;

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
    public final void onFailure(String r3, Throwable r4) {
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + this.a.b, "sender emoji load failed " + r4);
        o r5 = this.a;
        r5.h(r5);
        r5.r(false);
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        Intrinsics.checkNotNullParameter(r1, "id");
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        ALogger.i("InteractAnimation.InteractEmojiAnimationTask" + this.a.b, "sender emoji load success");
        ((AnimatedDrawable2) r3).setAnimationListener(new u(this));
        return;
    }

    public v(o r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r2, Ref.ObjectRef r3, Ref.ObjectRef r4, EPointF r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
