package com.larus.chat.gallery.impl.preview.input;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.bottom.attachment.d1;
import com.larus.chat.gallery.impl.preview.provider.w0;
import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.ResourceRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ c a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ a(c r1, w0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r19) {
        c r1 = this.a;
        Function1 r2 = this.b;
        List r3 = (List) r19;
        Intrinsics.checkNotNullParameter(r3, "attachments");
        Iterator<T> r4 = r1.a.d().iterator();
    L3:
        int r6 = -1;
        int r7 = 0;
        if (r4.hasNext() == false) goto L18;
        com.larus.chat.gallery.api.o r5 = (com.larus.chat.gallery.api.o) r4.next();
        Iterator<com.larus.chat.gallery.api.o> r8 = r1.d.iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r8.next().a, r5.a) == true) goto L10;
        r7 = r7 + 1;
        goto L7
    L10:
        r6 = r7;
    L12:
        if (r6 < 0) goto L3;
        List<com.larus.chat.gallery.api.o> r9 = r1.d;
        com.larus.chat.gallery.api.o r10 = (com.larus.chat.gallery.api.o) ((LinkedHashMap) r1.e).get(r5.a);
        if (r10 == null) goto L17;
        r5 = r10;
    L17:
        ListProtector.set(r9, r6, r5);
        goto L3
    L18:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r3.iterator();
    L20:
        if (r12.hasNext() == false) goto L139;
        AttachmentSnapshot r13 = (AttachmentSnapshot) r12.next();
        Iterator<T> r14 = r1.d.iterator();
    L22:
        Integer r15 = null;
        com.larus.chat.gallery.api.o r16 = null;
        if (r14.hasNext() == false) goto L27;
        Object r17 = r14.next();
        if (Intrinsics.areEqual(((com.larus.chat.gallery.api.o) r17).a, r13.getStableId()) == false) goto L22;
    L28:
        com.larus.chat.gallery.api.o r18 = (com.larus.chat.gallery.api.o) r17;
        boolean r20 = true;
        if (r18 != null) goto L88;
        String r21 = d1.c(r13);
        if (r21 != null) goto L33;
    L60:
        ResourceRef r22 = r13.effectiveRef();
        if (r22 == null) goto L84;
        String r23 = r22.getUri();
        if (r23 == null) goto L84;
        if ((!StringsKt.isBlank(r23)) == true) goto L68;
        r23 = null;
    L68:
        if (r23 == null) goto L84;
        Iterator<T> r110 = r1.d.iterator();
    L72:
        if (r110.hasNext() == false) goto L82;
        Object r111 = r110.next();
        com.larus.chat.gallery.api.o r112 = (com.larus.chat.gallery.api.o) r111;
        if (Intrinsics.areEqual(r112.b, r23) == false) goto L76;
    L79:
        boolean r113 = true;
    L80:
        if (r113 == false) goto L72;
    L83:
        com.larus.chat.gallery.api.o r114 = (com.larus.chat.gallery.api.o) r111;
    L85:
        r18 = r114;
    L86:
        if (r18 != null) goto L88;
    L137:
        if (r16 == null) goto L20;
        r11.add(r16);
        goto L20
    L76:
        if (Intrinsics.areEqual(r112.d, r23) == true) goto L79;
        r113 = false;
        goto L80
    L82:
        r111 = null;
    L84:
        r114 = null;
        goto L85
    L33:
        if ((!StringsKt.isBlank(r21)) == true) goto L36;
        r21 = null;
    L36:
        if (r21 == null) goto L60;
        Iterator r115 = CollectionsKt.plus(r1.d, r1.a.d()).iterator();
    L39:
        if (r115.hasNext() == false) goto L49;
        Object r116 = r115.next();
        com.larus.chat.gallery.api.o r117 = (com.larus.chat.gallery.api.o) r116;
        if (Intrinsics.areEqual(r117.b, r21) == false) goto L43;
    L46:
        boolean r118 = true;
    L47:
        if (r118 == false) goto L39;
    L50:
        com.larus.chat.gallery.api.o r119 = (com.larus.chat.gallery.api.o) r116;
        if (r119 == null) goto L60;
        Iterator<T> r24 = r1.d.iterator();
    L54:
        if (r24.hasNext() == false) goto L58;
        Object r120 = r24.next();
        if (Intrinsics.areEqual(((com.larus.chat.gallery.api.o) r120).a, r119.a) == false) goto L54;
    L59:
        r18 = (com.larus.chat.gallery.api.o) r120;
        goto L86
    L58:
        r120 = null;
        goto L59
    L43:
        if (Intrinsics.areEqual(r117.d, r21) == true) goto L46;
        r118 = false;
        goto L47
    L49:
        r116 = null;
    L88:
        com.larus.chat.gallery.api.o r121 = (com.larus.chat.gallery.api.o) ((LinkedHashMap) r1.e).get(r18.a);
        if (r121 == null) goto L92;
        r16 = r121;
        goto L137
    L92:
        if (r13.getEditState() == null) goto L96;
        ResourceRef r122 = r13.effectiveRef();
        if (r122 == null) goto L96;
        String r123 = r122.getUri();
        ResourceRef r124 = r13.getThumbRef();
        if (r124 == null) goto L101;
        String r125 = r124.getUri();
        if (r125 == null) goto L101;
    L108:
        Integer r25 = Integer.valueOf(r122.getWidth());
        if (r25.intValue() <= 0) goto L111;
        boolean r126 = true;
    L112:
        if (r126 == true) goto L115;
        r25 = null;
    L115:
        if (r25 == null) goto L117;
        int r26 = r25.intValue();
    L118:
        int r127 = r26;
        Integer r27 = Integer.valueOf(r122.getHeight());
        if (r27.intValue() > 0) goto L122;
        r20 = false;
    L122:
        if (r20 == false) goto L124;
        r15 = r27;
    L124:
        if (r15 == null) goto L126;
        int r28 = r15.intValue();
    L127:
        r16 = com.larus.chat.gallery.api.o.a(r18, null, r123, r125, r127, r28, 69);
        Iterator<com.larus.chat.gallery.api.o> r29 = r1.d.iterator();
        int r30 = 0;
    L129:
        if (r29.hasNext() == false) goto L134;
        if (Intrinsics.areEqual(r29.next().a, r18.a) == true) goto L135;
        r30 = r30 + 1;
    L135:
        if (r30 < 0) goto L137;
        ListProtector.set(r1.d, r30, r16);
        goto L137
    L134:
        r30 = -1;
        goto L135
    L126:
        r28 = r18.f;
        goto L127
    L117:
        r26 = r18.e;
        goto L118
    L111:
        r126 = false;
    L101:
        r125 = r122.getUri();
        if (r13.getMediaType() != AttachmentMediaType.IMAGE) goto L104;
        boolean r31 = true;
    L105:
        if (r31 == true) goto L108;
        r125 = null;
        goto L108
    L104:
        r31 = false;
    L96:
        r16 = r18;
        goto L137
    L27:
        r17 = null;
        goto L28
    L139:
        r2.invoke(r11);
        return Unit.INSTANCE;
    }
}
