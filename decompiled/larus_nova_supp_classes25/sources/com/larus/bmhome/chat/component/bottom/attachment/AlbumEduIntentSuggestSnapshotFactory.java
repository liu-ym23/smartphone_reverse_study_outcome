package com.larus.bmhome.chat.component.bottom.attachment;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AlbumEduIntentSuggestSnapshotFactory {
    public static final Set<SuggestedActionScene> a = null;
    public static final Set<String> b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0019\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/attachment/AlbumEduIntentSuggestSnapshotFactory$BlockReason;", "", "<init>", "(Ljava/lang/String;I)V", "BASE_SCENE_UNAVAILABLE", "DETECT_DISABLED", "OVERSEA", "ENTERPRISE_ACCOUNT", "MINOR_MODE", "NOT_MAIN_BOT_CONVERSATION", "NOT_MAIN_BOT_HOST_SCENE", "UNSUPPORTED_INJECT_INPUT", "INSTRUCTION_OPEN", "IMAGE_ATTACHMENT_INSTRUCTION_OPEN", "DRAFT_IMAGE_ATTACHMENT_INSTRUCTION", "DRAFT_PODCAST_INSTRUCTION", "SUGGESTED_ACTION_FORCED_BANNED", "REFERENCE_MESSAGE_BANNED", "CUSTOM_RESOURCE_BAR_ITEMS_EXIST", "UNSUPPORTED_SUGGESTED_ACTION_SCENE", "EMPTY_ATTACHMENTS", "NON_IMAGE_ATTACHMENT_EXISTS", "UNSUPPORTED_ATTACHMENT_SOURCE", "IMAGE_SOURCE_UNAVAILABLE", "CACHE_KEY_UNAVAILABLE", "FORCE_DISABLE_ALBUM_INTENT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum BlockReason extends Enum<BlockReason> {
        public static final BlockReason BASE_SCENE_UNAVAILABLE = null;
        public static final BlockReason CACHE_KEY_UNAVAILABLE = null;
        public static final BlockReason CUSTOM_RESOURCE_BAR_ITEMS_EXIST = null;
        public static final BlockReason DETECT_DISABLED = null;
        public static final BlockReason DRAFT_IMAGE_ATTACHMENT_INSTRUCTION = null;
        public static final BlockReason DRAFT_PODCAST_INSTRUCTION = null;
        public static final BlockReason EMPTY_ATTACHMENTS = null;
        public static final BlockReason ENTERPRISE_ACCOUNT = null;
        public static final BlockReason FORCE_DISABLE_ALBUM_INTENT = null;
        public static final BlockReason IMAGE_ATTACHMENT_INSTRUCTION_OPEN = null;
        public static final BlockReason IMAGE_SOURCE_UNAVAILABLE = null;
        public static final BlockReason INSTRUCTION_OPEN = null;
        public static final BlockReason MINOR_MODE = null;
        public static final BlockReason NON_IMAGE_ATTACHMENT_EXISTS = null;
        public static final BlockReason NOT_MAIN_BOT_CONVERSATION = null;
        public static final BlockReason NOT_MAIN_BOT_HOST_SCENE = null;
        public static final BlockReason OVERSEA = null;
        public static final BlockReason REFERENCE_MESSAGE_BANNED = null;
        public static final BlockReason SUGGESTED_ACTION_FORCED_BANNED = null;
        public static final BlockReason UNSUPPORTED_ATTACHMENT_SOURCE = null;
        public static final BlockReason UNSUPPORTED_INJECT_INPUT = null;
        public static final BlockReason UNSUPPORTED_SUGGESTED_ACTION_SCENE = null;
        public static final /* synthetic */ BlockReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BlockReason> getEntries() {
            return b;
        }

        static {
            BlockReason r0 = new BlockReason("BASE_SCENE_UNAVAILABLE", 0);
            BASE_SCENE_UNAVAILABLE = r0;
            BlockReason r1 = new BlockReason("DETECT_DISABLED", 1);
            DETECT_DISABLED = r1;
            BlockReason r3 = new BlockReason("OVERSEA", 2);
            OVERSEA = r3;
            BlockReason r5 = new BlockReason("ENTERPRISE_ACCOUNT", 3);
            ENTERPRISE_ACCOUNT = r5;
            BlockReason r7 = new BlockReason("MINOR_MODE", 4);
            MINOR_MODE = r7;
            BlockReason r9 = new BlockReason("NOT_MAIN_BOT_CONVERSATION", 5);
            NOT_MAIN_BOT_CONVERSATION = r9;
            BlockReason r11 = new BlockReason("NOT_MAIN_BOT_HOST_SCENE", 6);
            NOT_MAIN_BOT_HOST_SCENE = r11;
            BlockReason r13 = new BlockReason("UNSUPPORTED_INJECT_INPUT", 7);
            UNSUPPORTED_INJECT_INPUT = r13;
            BlockReason r15 = new BlockReason("INSTRUCTION_OPEN", 8);
            INSTRUCTION_OPEN = r15;
            BlockReason r14 = new BlockReason("IMAGE_ATTACHMENT_INSTRUCTION_OPEN", 9);
            IMAGE_ATTACHMENT_INSTRUCTION_OPEN = r14;
            BlockReason r12 = new BlockReason("DRAFT_IMAGE_ATTACHMENT_INSTRUCTION", 10);
            DRAFT_IMAGE_ATTACHMENT_INSTRUCTION = r12;
            BlockReason r10 = new BlockReason("DRAFT_PODCAST_INSTRUCTION", 11);
            DRAFT_PODCAST_INSTRUCTION = r10;
            BlockReason r8 = new BlockReason("SUGGESTED_ACTION_FORCED_BANNED", 12);
            SUGGESTED_ACTION_FORCED_BANNED = r8;
            BlockReason r6 = new BlockReason("REFERENCE_MESSAGE_BANNED", 13);
            REFERENCE_MESSAGE_BANNED = r6;
            BlockReason r4 = new BlockReason("CUSTOM_RESOURCE_BAR_ITEMS_EXIST", 14);
            CUSTOM_RESOURCE_BAR_ITEMS_EXIST = r4;
            BlockReason r2 = new BlockReason("UNSUPPORTED_SUGGESTED_ACTION_SCENE", 15);
            UNSUPPORTED_SUGGESTED_ACTION_SCENE = r2;
            BlockReason r16 = new BlockReason("EMPTY_ATTACHMENTS", 16);
            EMPTY_ATTACHMENTS = r16;
            BlockReason r17 = new BlockReason("NON_IMAGE_ATTACHMENT_EXISTS", 17);
            NON_IMAGE_ATTACHMENT_EXISTS = r17;
            BlockReason r18 = new BlockReason("UNSUPPORTED_ATTACHMENT_SOURCE", 18);
            UNSUPPORTED_ATTACHMENT_SOURCE = r18;
            BlockReason r19 = new BlockReason("IMAGE_SOURCE_UNAVAILABLE", 19);
            IMAGE_SOURCE_UNAVAILABLE = r19;
            BlockReason r20 = new BlockReason("CACHE_KEY_UNAVAILABLE", 20);
            CACHE_KEY_UNAVAILABLE = r20;
            BlockReason r21 = new BlockReason("FORCE_DISABLE_ALBUM_INTENT", 21);
            FORCE_DISABLE_ALBUM_INTENT = r21;
            BlockReason[] r22 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21};
            a = r22;
            b = EnumEntriesKt.enumEntries(r22);
        }

        public static BlockReason[] values() {
            return (BlockReason[]) a.clone();
        }

        public static BlockReason valueOf(String r1) {
            return (BlockReason) r27.a.a(BlockReason.class, r1);
        }

        public BlockReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final String b;

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
            return "CacheKeyResolution(key=" + this.a + ", origin=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "origin");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L54;
            return false;
        L54:
            if (this.p == r6.p) goto L56;
            return false;
        L56:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.c == false) goto L13;
            int r5 = 1231;
        L14:
            int r6 = (r4 + r5) * 31;
            if (this.d == false) goto L17;
            int r7 = 1231;
        L18:
            int r8 = (r6 + r7) * 31;
            if (this.e == false) goto L21;
            int r9 = 1231;
        L22:
            int r10 = (r8 + r9) * 31;
            if (this.f == false) goto L25;
            int r11 = 1231;
        L26:
            int r12 = (r10 + r11) * 31;
            if (this.g == false) goto L29;
            int r13 = 1231;
        L30:
            int r14 = (r12 + r13) * 31;
            if (this.h == false) goto L33;
            int r15 = 1231;
        L34:
            int r16 = (r14 + r15) * 31;
            if (this.i == false) goto L37;
            int r17 = 1231;
        L38:
            int r18 = (r16 + r17) * 31;
            if (this.j == false) goto L41;
            int r19 = 1231;
        L42:
            int r20 = (r18 + r19) * 31;
            if (this.k == false) goto L45;
            int r21 = 1231;
        L46:
            int r22 = (r20 + r21) * 31;
            if (this.l == false) goto L49;
            int r23 = 1231;
        L50:
            int r24 = (r22 + r23) * 31;
            if (this.m == false) goto L53;
            int r25 = 1231;
        L54:
            int r26 = (r24 + r25) * 31;
            if (this.n == false) goto L57;
            int r27 = 1231;
        L58:
            int r28 = (r26 + r27) * 31;
            if (this.o == false) goto L61;
            int r29 = 1231;
        L62:
            int r30 = (r28 + r29) * 31;
            if (this.p == true) goto L67;
            r1 = 1237;
        L67:
            return r30 + r1;
        L61:
            r29 = 1237;
            goto L62
        L57:
            r27 = 1237;
            goto L58
        L53:
            r25 = 1237;
            goto L54
        L49:
            r23 = 1237;
            goto L50
        L45:
            r21 = 1237;
            goto L46
        L41:
            r19 = 1237;
            goto L42
        L37:
            r17 = 1237;
            goto L38
        L33:
            r15 = 1237;
            goto L34
        L29:
            r13 = 1237;
            goto L30
        L25:
            r11 = 1237;
            goto L26
        L21:
            r9 = 1237;
            goto L22
        L17:
            r7 = 1237;
            goto L18
        L13:
            r5 = 1237;
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Eligibility(detectEnabled=" + this.a + ", isOversea=" + this.b + ", isEnterpriseAccount=" + this.c + ", isInMinorMode=" + this.d + ", isMainBotConversation=" + this.e + ", isMainBotHostScene=" + this.f + ", isInjectInput=" + this.g + ", isPhotoPickerInjectInput=" + this.h + ", isInstructionOpen=" + this.i + ", hasImageAttachmentInstruction=" + this.j + ", hasDraftImageAttachmentInstruction=" + this.k + ", hasDraftPodcastInstruction=" + this.l + ", forceBanSuggestedAction=" + this.m + ", banSuggestedActionByReferenceMessage=" + this.n + ", hasCustomResourceBarItems=" + this.o + ", forceDisableAlbumIntent=" + this.p + ')';
        }

        public b(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18) {
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
            this.l = r14;
            this.m = r15;
            this.n = r16;
            this.o = r17;
            this.p = r18;
        }
    }

    public static final class c {
        public final String a;
        public final SuggestedActionScene b;
        public final String c;
        public final String d;
        public final List<UplinkFileEntity> e;
        public final b f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
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
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            SuggestedActionScene r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
            String r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Input(conversationId=" + this.a + ", baseScene=" + this.b + ", bizScene=" + this.c + ", firstFromScene=" + this.d + ", attachments=" + this.e + ", eligibility=" + this.f + ')';
        }

        public c(String r2, SuggestedActionScene r3, String r4, String r5, List<UplinkFileEntity> r6, b r7) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            Intrinsics.checkNotNullParameter(r4, "bizScene");
            Intrinsics.checkNotNullParameter(r6, "attachments");
            Intrinsics.checkNotNullParameter(r7, "eligibility");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public AlbumEduIntentSuggestSnapshotFactory() {
    }

    static {
        a = SetsKt.setOf(new SuggestedActionScene[]{SuggestedActionScene.AttachmentAreaSingleImg, SuggestedActionScene.AttachmentAreaMultiImg});
        b = SetsKt.setOf(new String[]{"album", "file", "paste"});
    }

    public static String b(com.larus.bmhome.chat.component.bottom.attachment.a r8) {
        if ((r8 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.b) == false) goto L29;
        Uri r9 = ((com.larus.bmhome.chat.component.bottom.attachment.a.b) r8).a;
        String r0 = r9.getScheme();
        if (r0 == null) goto L19;
        int r1 = r0.hashCode();
        if (r1 == 0) goto L17;
        if (r1 == 3143036) goto L12;
    L18:
        PolarisFileWrapper r2 = null;
    L20:
        StringBuilder r3 = new StringBuilder();
        r3.append(r9);
        if (r2 == null) goto L37;
        long r4 = r2.length();
        long r5 = r2.lastModified();
        if (r4 <= 0) goto L25;
    L26:
        r3.append('|');
        r3.append(r4);
        r3.append('|');
        r3.append(r5);
        goto L37
    L25:
        if (r5 > 0) goto L26;
    L37:
        return r3.toString();
    L12:
        if (r0.equals("file") == false) goto L18;
        String r6 = r9.getPath();
        if (r6 == null) goto L18;
        r2 = new PolarisFileWrapper(r6);
        goto L20
    L17:
        if (r0.equals("") == false) goto L18;
    L19:
        r2 = new PolarisFileWrapper(r9.toString());
        goto L20
    L29:
        if ((r8 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.c) == false) goto L32;
        return ((com.larus.bmhome.chat.component.bottom.attachment.a.c) r8).a;
    L32:
        if ((r8 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.C0043a) == false) goto L36;
        return ((com.larus.bmhome.chat.component.bottom.attachment.a.C0043a) r8).a;
    L36:
        throw new NoWhenBranchMatchedException();
    }

    public static boolean c(Uri r2) {
        String r3 = r2.getScheme();
        if (r3 == null) goto L24;
        int r0 = r3.hashCode();
        if (r0 == (-368816979)) goto L22;
        if (r0 == 0) goto L19;
        if (r0 == 3143036) goto L16;
        if (r0 == 951530617) goto L13;
    L23:
        return false;
    L13:
        if (r3.equals("content") == false) goto L23;
    L16:
        if (r3.equals("file") == true) goto L24;
    L19:
        if (r3.equals("") == true) goto L24;
    L22:
        if (r3.equals("android.resource") == false) goto L23;
    L24:
        return true;
    }

    public static void a(c r4, BlockReason r5, String r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[create] blocked, reason=");
        r1.append(r5);
        r1.append(", baseScene=");
        r1.append(r4.b);
        r1.append(", bizScene=");
        r1.append(r4.c);
        r1.append(", firstFromScene=");
        r1.append(r4.d);
        r1.append(", attachmentCount=");
        r1.append(r4.e.size());
        r1.append(", useDraft=");
        List<UplinkFileEntity> r7 = r4.e;
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((UplinkFileEntity) r8.next()).isFromDraft(), Boolean.TRUE) == false) goto L9;
        boolean r9 = true;
    L14:
        r1.append(r9);
        r1.append(", isInMinorMode=");
        r1.append(r4.f.d);
        r1.append(", isMainBotHostScene=");
        r1.append(r4.f.f);
        r1.append(", isInjectInput=");
        r1.append(r4.f.g);
        r1.append(", isPhotoPickerInjectInput=");
        r1.append(r4.f.h);
        if (r6 == null) goto L17;
        String r10 = ", ".concat(r6);
    L18:
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        r1.append(r10);
        r0.i("AlbumEduSnapshotFactory", r1.toString());
        return;
    L17:
        r10 = null;
    L13:
        r9 = false;
        goto L14
    L5:
        if (r7.isEmpty() == false) goto L7;
        goto L7
    }
}
