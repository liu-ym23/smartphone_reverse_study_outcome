package ef8;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final Message a;
    public final q0.a b;
    public final q0 c;
    public final by7.e d;
    public final Function0<Long> e;
    public final df8.a f;
    public final SearchImageInfo g;
    public final CustomMarkdownTextView h;
    public final a i;
    public final AiGenVideoContentData j;
    public final UplinkFileEntity k;
    public final JSONObject l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        q0.a r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        q0 r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        by7.e r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Function0<Long> r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        df8.a r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        SearchImageInfo r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        CustomMarkdownTextView r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        a r23 = this.i;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        AiGenVideoContentData r26 = this.j;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        UplinkFileEntity r29 = this.k;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        JSONObject r32 = this.l;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return r31 + r2;
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuContext(data=" + this.a + ", modelProvider=" + this.b + ", adapter=" + this.c + ", trackNode=" + this.d + ", getChatUniqueKey=" + this.e + ", imageItemInfo=" + this.f + ", awemeImageItem=" + this.g + ", markdownView=" + this.h + ", groupAbility=" + this.i + ", videoInfo=" + this.j + ", attachmentEntity=" + this.k + ", extraParams=" + this.l + ')';
    }

    public final BotModel a() {
        q0.a r0 = this.b;
        if (r0 == null) goto L7;
        y r1 = r0.u0();
        if (r1 == null) goto L7;
        return r1.j0();
    L7:
        return null;
    }

    public final long b() {
        Function0<Long> r0 = this.e;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return ((Number) r0.invoke()).longValue();
    }

    public final wc9.e c() {
        q0.a r0 = this.b;
        if (r0 == null) goto L7;
        y r1 = r0.u0();
        if (r1 == null) goto L7;
        return r1.h();
    L7:
        return null;
    }

    public /* synthetic */ b(Message r17, q0.a r18, q0 r19, by7.e r20, Function0 r21, df8.a r22, SearchImageInfo r23, PopMenuPanelTrigger.c r24, AiGenVideoContentData r25, UplinkFileEntity r26, JSONObject r27, int r28) {
        if ((r28 & 8) == 0) goto L5;
        by7.e r7 = null;
    L7:
        if ((r28 & 16) == 0) goto L9;
        Function0 r8 = null;
    L11:
        if ((r28 & 32) == 0) goto L13;
        df8.a r9 = null;
    L15:
        if ((r28 & 64) == 0) goto L17;
        SearchImageInfo r10 = null;
    L19:
        if ((r28 & 256) == 0) goto L21;
        PopMenuPanelTrigger.c r12 = null;
    L23:
        if ((r28 & 512) == 0) goto L25;
        AiGenVideoContentData r13 = null;
    L27:
        if ((r28 & 1024) == 0) goto L29;
        UplinkFileEntity r14 = null;
    L31:
        if ((r28 & 2048) == 0) goto L33;
        JSONObject r15 = null;
    L34:
        this(r17, r18, r19, r7, r8, r9, r10, null, r12, r13, r14, r15);
        return;
    L33:
        r15 = r27;
        goto L34
    L29:
        r14 = r26;
        goto L31
    L25:
        r13 = r25;
        goto L27
    L21:
        r12 = r24;
        goto L23
    L17:
        r10 = r23;
        goto L19
    L13:
        r9 = r22;
        goto L15
    L9:
        r8 = r21;
        goto L11
    L5:
        r7 = r20;
        goto L7
    }

    public b(Message r2, q0.a r3, q0 r4, by7.e r5, Function0<Long> r6, df8.a r7, SearchImageInfo r8, CustomMarkdownTextView r9, a r10, AiGenVideoContentData r11, UplinkFileEntity r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
