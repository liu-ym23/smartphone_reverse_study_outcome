package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import am2.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$ViewBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.f3;
import com.bytedance.android.livesdk.message.model.z6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.livesdk.interactivity.api.publicscreen.j<c, PublicScreenCombinedTextViewHolder> {
    public final PublicScreenConfig$ViewBinderType a;

    public d() {
        this.a = PublicScreenConfig$ViewBinderType.COMBINED_TEXT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PublicScreenConfig$ViewBinderType a() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PSMessageViewHolder c(LayoutInflater r2, ViewGroup r3, g52.c r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutInflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = r2.inflate(2131566246, r3, false);
        if (r5.getLayoutParams() != null) goto L6;
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L6:
        return new PublicScreenCombinedTextViewHolder(r5);
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
    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void b(PSMessageViewHolder r8, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r9, int r10, g52.e r11) {
        PublicScreenCombinedTextViewHolder r13 = (PublicScreenCombinedTextViewHolder) r8;
        c r14 = (c) r9;
        Intrinsics.checkNotNullParameter(r13, "viewHolder");
        Intrinsics.checkNotNullParameter(r14, "item");
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "model");
        r13.k.invoke(r14);
        g52.a r15 = r13.e;
        if (r15 == null) goto L5;
        r15.setDispatchCallback(r13);
    L5:
        Integer r16 = null;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r0 = m.a(null);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r0.getValue();
        if (r1 == null) goto L10;
        e52.a r2 = r1.getTextConfig();
    L12:
        if (r2 == null) goto L14;
        r13.W3(r2, r14, false);
    L14:
        tb2.d r3 = r14.p();
        if (r3 == null) goto L23;
        NoMoreSpaceTextView r4 = r13.b;
        z6 r5 = r14.l;
        if (r5 == null) goto L21;
        f3 r6 = r5.t();
        if (r6 == null) goto L21;
        Integer r7 = Integer.valueOf(r6.b());
    L22:
        int r17 = mb2.c.a;
        ek6.e r18 = mb2.c.c(r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(r2), "public_screen");
        PublicScreenCombinedTextViewHolder.X3(r4, r7);
        LiveRichContentEngine.a().a().c(r18, new qb2.g(false, 0.0f, 7), new l(r13, r4, r11));
        UtilityKotlinExtentionsKt.w(r13.b);
    L24:
        boolean r19 = !r14.k().a.a.isEmpty();
        String r20 = BuildConfig.FLAVOR;
        if (r19 == false) goto L47;
        UtilityKotlinExtentionsKt.w(r13.c);
        NoMoreSpaceTextView r21 = r13.c;
        r21.setAlwaysInvalidate(r14.k().c);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r23 = r13.i;
        if (r23 == null) goto L29;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r24 = r23.b(r14, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new k(r13, r21));
    L30:
        t.a r25 = t.a;
        if (r24 == null) goto L35;
        CharSequence r26 = r24.a;
        if (r26 == null) goto L35;
    L36:
        t.b(r21, r26);
        z6 r27 = r14.l;
        if (r27 == null) goto L41;
        f3 r28 = r27.Y();
        if (r28 == null) goto L41;
        r16 = Integer.valueOf(r28.b());
    L41:
        PublicScreenCombinedTextViewHolder.X3(r21, r16);
        r13.Z3(r21);
        if (r11 == null) goto L44;
        int r110 = g52.e.j;
        r11.a(r21, true);
    L44:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r29 = r13.i;
        if (r29 == null) goto L49;
        r29.a(r14);
    L49:
        if (r14.o() == true) goto L65;
        z6 r30 = r14.l;
        Pair[] r111 = new Pair[1];
        if (r30 == null) goto L56;
        String r112 = r30.getBizScene();
        if (r112 == null) goto L56;
        r20 = r112;
    L56:
        r111[0] = TuplesKt.to("msg_show_type", r20);
        HashMap r113 = MapsKt.hashMapOf(r111);
        if (r30 == null) goto L63;
        IPublicAreaCommon r31 = r30.getPublicAreaCommon();
        if (r31 == null) goto L63;
        Map r33 = r31.getTrackingParams();
        if (r33 == null) goto L63;
        r113.putAll(r33);
    L63:
        j0.l().sendLog("livesdk_public_screen_combined_text_message_show", r113, new Object[]{IRoom.class, x.class});
        r14.q();
        return;
    L65:
        return;
    L35:
        r26 = BuildConfig.FLAVOR;
        goto L36
    L29:
        r24 = null;
        goto L30
    L47:
        UtilityKotlinExtentionsKt.t(r13.c);
    L21:
        r7 = null;
        goto L22
    L23:
        UtilityKotlinExtentionsKt.t(r13.b);
    L10:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void d(PSMessageViewHolder r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r3, int r4, g52.e r5) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "item");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.j.a.a(this, r2, r3, r4, r5);
    }
}
