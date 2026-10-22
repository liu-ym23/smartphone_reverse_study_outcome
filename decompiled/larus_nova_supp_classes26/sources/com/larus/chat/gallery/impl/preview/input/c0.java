package com.larus.chat.gallery.impl.preview.input;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.OutputParam;
import com.larus.platform.model.action.PromptReplacementCfg;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0 implements e0 {
    public final List<com.larus.chat.gallery.api.o> a;
    public final com.larus.chat.gallery.api.q b;
    public Function1<? super Boolean, Unit> c;
    public a d;
    public a0 e;

    public static final class a {
        public final List<String> a;
        public final Function1<com.larus.chat.gallery.api.w, com.larus.chat.gallery.api.w> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PendingSend(expectedStableIds=" + this.a + ", decorateSnapshot=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<String> r2, Function1<? super com.larus.chat.gallery.api.w, com.larus.chat.gallery.api.w> r3) {
            Intrinsics.checkNotNullParameter(r2, "expectedStableIds");
            Intrinsics.checkNotNullParameter(r3, "decorateSnapshot");
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final void c(boolean r1) {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final SuggestedAction i() {
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean d() {
        if (this.d == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final void a(com.larus.chat.gallery.impl.preview.provider.a0 r2) {
        this.c = r2;
        if (r2 != null) goto L9;
        a0 r3 = this.e;
        if (r3 == null) goto L7;
        this.b.b(r3);
    L7:
        this.e = null;
        this.d = null;
        return;
    }

    public c0(List<com.larus.chat.gallery.api.o> r2, com.larus.chat.gallery.api.q r3) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r3, "session");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean h(String r2, xy8.d r3) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r3, "data");
        return k(r2, r3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.larus.chat.gallery.impl.preview.input.a0, kotlin.jvm.functions.Function1] */
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
    public final boolean l(boolean r4, Function1<? super com.larus.chat.gallery.api.w, com.larus.chat.gallery.api.w> r5) {
        com.larus.chat.gallery.api.w r0 = this.b.h();
        if (r0 == null) goto L7;
        return this.b.m((com.larus.chat.gallery.api.w) r5.invoke(r0)).c;
    L7:
        if (r4 == true) goto L9;
    L19:
        return false;
    L9:
        if (this.d != null) goto L19;
        List<AttachmentSnapshot> r6 = this.b.Qa();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L16;
        r1.add(((AttachmentSnapshot) r7.next()).getStableId());
        goto L13
    L16:
        if (r1.isEmpty() == false) goto L18;
        return false;
    L18:
        this.d = new a(r1, r5);
        ?? r8 = new a0(this);
        this.e = r8;
        this.b.f(r8);
        goto L19
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean b(final SuggestedAction r6, xy8.d r7, final String r8) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "data");
        boolean r1 = false;
        if (this.b.Qa().isEmpty() == false) goto L21;
        Iterator<T> r0 = this.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((com.larus.chat.gallery.api.o) r2).a, r7.b) == false) goto L6;
    L11:
        com.larus.chat.gallery.api.o r3 = (com.larus.chat.gallery.api.o) r2;
        if (r3 != null) goto L14;
        return false;
    L14:
        com.larus.chat.gallery.api.a0 r9 = this.b.Pa(r3.a, true);
        if (r9.a == true) goto L17;
    L20:
        return false;
    L17:
        if (r9.b == false) goto L20;
        r1 = true;
        goto L21
    L10:
        r2 = null;
    L21:
        Map r10 = r6.getMsgExt();
        if (r10 == null) goto L25;
        final Map r11 = MapsKt.toMutableMap(r10);
        if (r11 == null) goto L25;
    L26:
        PromptReplacementCfg r4 = r6.getPromptReplacementCfg();
        if (r4 == null) goto L32;
        String r5 = r4.getReplacementKey();
        if (r5 == null) goto L32;
        r11.put("prompt_modification", r5);
    L32:
        return l(r1, new b0(r6, r8, r11));
    L25:
        r11 = new LinkedHashMap();
        goto L26
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean e(String r2, xy8.d r3, zy8.s r4) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r3, "data");
        return k(r2, r3, r4);
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean f(String r2, CameraOutputContext r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r3, "outputContext");
        return j(r2, r3, null, r4);
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean g(SuggestedAction r2, CameraOutputContext r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "suggestedAction");
        Intrinsics.checkNotNullParameter(r3, "outputContext");
        String r0 = r2.getDisplayName();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return j(r0, r3, r2, r4);
    }

    public final boolean k(final String r6, xy8.d r7, final zy8.s r8) {
        boolean r1 = false;
        if (this.b.Qa().isEmpty() == false) goto L22;
        Iterator<T> r0 = this.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((com.larus.chat.gallery.api.o) r2).a, r7.b) == false) goto L6;
    L11:
        com.larus.chat.gallery.api.o r3 = (com.larus.chat.gallery.api.o) r2;
        if (r3 != null) goto L14;
        return false;
    L14:
        com.larus.chat.gallery.api.a0 r9 = this.b.Pa(r3.a, true);
        if (r9.a == true) goto L17;
    L20:
        return false;
    L17:
        if (r9.b == false) goto L20;
        r1 = true;
        goto L22
    L10:
        r2 = null;
    L22:
        return l(r1, new z(r6, r8));
    }

    public final boolean j(String r27, CameraOutputContext r28, SuggestedAction r29, Map<String, String> r30) {
        Map<String, String> r15 = r30;
        List<com.larus.chat.gallery.api.o> r0 = wy8.a.a(r28);
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = ((ArrayList) r0).iterator();
        boolean r2 = false;
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L10;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r14.add(com.larus.chat.gallery.api.p.a((com.larus.chat.gallery.api.o) r4, AttachmentSource.CAMERA, r3));
        r3 = r5;
        goto L4
    L10:
        if (r14.isEmpty() == false) goto L12;
        return false;
    L12:
        List<OutputParam> r6 = r28.getOutputParamList();
        if (r6 == null) goto L21;
        OutputParam r7 = (OutputParam) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L21;
        HashMap<String, String> r8 = r7.getExt();
        if (r8 == null) goto L21;
        Map r9 = MapsKt.toMutableMap(r8);
        if (r9 == null) goto L21;
    L22:
        if (r29 == null) goto L26;
        Map r10 = r29.getMsgExt();
        if (r10 == null) goto L26;
        r9.putAll(r10);
    L26:
        if (r29 == null) goto L32;
        PromptReplacementCfg r11 = r29.getPromptReplacementCfg();
        if (r11 == null) goto L32;
        String r12 = r11.getReplacementKey();
        if (r12 == null) goto L32;
        r9.put("prompt_modification", r12);
    L32:
        List<OutputParam> r13 = r28.getOutputParamList();
        if (r13 == null) goto L53;
        List<OutputParam> r16 = r13;
        if ((r16 instanceof Collection) == true) goto L37;
    L39:
        Iterator<T> r17 = r16.iterator();
    L41:
        if (r17.hasNext() == false) goto L50;
        OutputParam r18 = (OutputParam) r17.next();
        if (r18 != null) goto L45;
    L47:
        boolean r19 = false;
    L48:
        if (r19 == false) goto L41;
        boolean r20 = true;
    L51:
        if (r20 != true) goto L53;
        r2 = true;
        goto L53
    L45:
        if (r18.isImageMarked() != true) goto L47;
        r19 = true;
    L50:
        r20 = false;
        goto L51
    L37:
        if (r16.isEmpty() == false) goto L39;
    L53:
        if (r2 == false) goto L55;
        String r21 = "1";
    L56:
        r9.put("ref_img_paint_mark", r21);
        if (r29 == null) goto L63;
        Map r22 = r29.getEventExtra();
        if (r22 == null) goto L62;
        String r23 = (String) r22.get("sug_scene");
        if (r23 == null) goto L62;
    L67:
        String r110 = r23;
    L70:
        if ((!r9.isEmpty()) == false) goto L72;
        Map r111 = r9;
    L73:
        if (r29 == null) goto L86;
        Map r24 = r29.getEventExtra();
        if (r24 == null) goto L78;
        Map r25 = MapsKt.toMutableMap(r24);
        if (r25 == null) goto L78;
    L79:
        if (r15 == null) goto L81;
        r25.putAll(r15);
    L81:
        r25.putIfAbsent("scene", "album");
        Unit r112 = Unit.INSTANCE;
        if ((!r25.isEmpty()) == false) goto L84;
        Map r113 = r25;
    L85:
        SuggestedAction r26 = SuggestedAction.copy$default(r29, null, 0, 0, null, false, null, null, null, null, r113, null, null, 3583, null);
    L87:
        if (r15 != null) goto L89;
        Map<String, String> r31 = MapsKt.emptyMap();
    L90:
        Map r32 = MapsKt.toMutableMap(r31);
        r32.putIfAbsent("scene", "album");
        if (r15 != null) goto L93;
        r15 = MapsKt.emptyMap();
    L93:
        Map r33 = MapsKt.toMutableMap(r15);
        String r114 = r110;
        r33.put("scene", r114);
        return this.b.m(new com.larus.chat.gallery.api.w(r14, r27, r26, r114, r111, r32, r33, 128)).c;
    L89:
        r31 = r15;
        goto L90
    L84:
        r113 = null;
    L78:
        r25 = new LinkedHashMap();
        goto L79
    L86:
        r26 = null;
        goto L87
    L72:
        r111 = null;
    L62:
        r23 = "attachment_suggest";
        goto L67
    L63:
        if (r15 == null) goto L68;
        r23 = r15.get("scene");
        if (r23 != null) goto L67;
    L68:
        r110 = "album";
        goto L70
    L55:
        r21 = TriggerSendLoading.NO_LOADING;
    L21:
        r9 = new LinkedHashMap();
        goto L22
    }
}
