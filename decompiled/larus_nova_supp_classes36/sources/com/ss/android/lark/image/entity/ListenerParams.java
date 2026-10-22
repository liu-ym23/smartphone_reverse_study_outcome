package com.ss.android.lark.image.entity;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.inv.export.router.InvRouter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ListenerParams {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final b h;
    public final Biz i;
    public final Scene j;
    public final FromType k;
    public final ChatType l;
    public final String m;
    public final String n;
    public final String o;
    public final boolean p;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$ChatType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SINGLE", "GROUP", "TOPIC", "THREAD_DETAIL", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ChatType extends Enum<ChatType> {
        public static final ChatType GROUP = null;
        public static final ChatType SINGLE = null;
        public static final ChatType THREAD_DETAIL = null;
        public static final ChatType TOPIC = null;
        public static final ChatType UNKNOWN = null;
        public static final /* synthetic */ ChatType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<ChatType> getEntries() {
            return b;
        }

        static {
            ChatType r0 = new ChatType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChatType r1 = new ChatType("SINGLE", 1, 1);
            SINGLE = r1;
            ChatType r3 = new ChatType("GROUP", 2, 2);
            GROUP = r3;
            ChatType r5 = new ChatType("TOPIC", 3, 3);
            TOPIC = r5;
            ChatType r7 = new ChatType("THREAD_DETAIL", 4, 4);
            THREAD_DETAIL = r7;
            ChatType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static ChatType[] values() {
            return (ChatType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatType valueOf(String r1) {
            return (ChatType) r27.a.a(ChatType.class, r1);
        }

        public ChatType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$ColorSpace;", "", "value", "", "index", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getIndex", "()I", "UNKNOWN", "ACES", "ACESCG", "ADOBE_RGB", "BT2020", "BT709", "CIE_LAB", "CIE_XYZ", "DCI_P3", "DISPLAY_P3", "EXTENDED_SRGB", "LINEAR_EXTENDED_SRGB", "LINEAR_SRGB", "NTSC_1953", "PRO_PHOTO_RGB", "SMPTE_C", "SRGB", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ColorSpace extends Enum<ColorSpace> {
        public static final ColorSpace ACES = null;
        public static final ColorSpace ACESCG = null;
        public static final ColorSpace ADOBE_RGB = null;
        public static final ColorSpace BT2020 = null;
        public static final ColorSpace BT709 = null;
        public static final ColorSpace CIE_LAB = null;
        public static final ColorSpace CIE_XYZ = null;
        public static final ColorSpace DCI_P3 = null;
        public static final ColorSpace DISPLAY_P3 = null;
        public static final ColorSpace EXTENDED_SRGB = null;
        public static final ColorSpace LINEAR_EXTENDED_SRGB = null;
        public static final ColorSpace LINEAR_SRGB = null;
        public static final ColorSpace NTSC_1953 = null;
        public static final ColorSpace PRO_PHOTO_RGB = null;
        public static final ColorSpace SMPTE_C = null;
        public static final ColorSpace SRGB = null;
        public static final ColorSpace UNKNOWN = null;
        public static final /* synthetic */ ColorSpace[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int index;
        private final String value;

        public static EnumEntries<ColorSpace> getEntries() {
            return b;
        }

        static {
            ColorSpace r0 = new ColorSpace("UNKNOWN", 0, InvRouter.UNKNOWN, 0);
            UNKNOWN = r0;
            ColorSpace r1 = new ColorSpace("ACES", 1, "aces", 1);
            ACES = r1;
            ColorSpace r2 = new ColorSpace("ACESCG", 2, "acescg", 2);
            ACESCG = r2;
            ColorSpace r4 = new ColorSpace("ADOBE_RGB", 3, "adobe_rgb", 3);
            ADOBE_RGB = r4;
            ColorSpace r6 = new ColorSpace("BT2020", 4, "bt2020", 4);
            BT2020 = r6;
            ColorSpace r8 = new ColorSpace("BT709", 5, "bt709", 5);
            BT709 = r8;
            ColorSpace r10 = new ColorSpace("CIE_LAB", 6, "cie_lab", 6);
            CIE_LAB = r10;
            ColorSpace r12 = new ColorSpace("CIE_XYZ", 7, "cie_xyz", 7);
            CIE_XYZ = r12;
            ColorSpace r14 = new ColorSpace("DCI_P3", 8, "dci_p3", 8);
            DCI_P3 = r14;
            ColorSpace r13 = new ColorSpace("DISPLAY_P3", 9, "display_p3", 9);
            DISPLAY_P3 = r13;
            ColorSpace r11 = new ColorSpace("EXTENDED_SRGB", 10, "extended_srgb", 10);
            EXTENDED_SRGB = r11;
            ColorSpace r9 = new ColorSpace("LINEAR_EXTENDED_SRGB", 11, "linear_extended_srgb", 11);
            LINEAR_EXTENDED_SRGB = r9;
            ColorSpace r7 = new ColorSpace("LINEAR_SRGB", 12, "linear_srgb", 12);
            LINEAR_SRGB = r7;
            ColorSpace r5 = new ColorSpace("NTSC_1953", 13, "ntsc_1953", 13);
            NTSC_1953 = r5;
            ColorSpace r3 = new ColorSpace("PRO_PHOTO_RGB", 14, "pro_photo_rgb", 14);
            PRO_PHOTO_RGB = r3;
            ColorSpace r15 = new ColorSpace("SMPTE_C", 15, "smpte_c", 15);
            SMPTE_C = r15;
            ColorSpace r16 = new ColorSpace("SRGB", 16, "srgb", 16);
            SRGB = r16;
            ColorSpace[] r17 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16};
            a = r17;
            b = EnumEntriesKt.enumEntries(r17);
        }

        public static ColorSpace[] values() {
            return (ColorSpace[]) a.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getValue() {
            return this.value;
        }

        public static ColorSpace valueOf(String r1) {
            return (ColorSpace) r27.a.a(ColorSpace.class, r1);
        }

        public ColorSpace(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            this.value = r3;
            this.index = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$ColorType;", "", "value", "", "index", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getIndex", "()I", "UNKNOWN", "ALPHA_8", "RGB_565", "ARGB_444", "RGBA_8888", "RGB_888X", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ColorType extends Enum<ColorType> {
        public static final ColorType ALPHA_8 = null;
        public static final ColorType ARGB_444 = null;
        public static final ColorType RGBA_8888 = null;
        public static final ColorType RGB_565 = null;
        public static final ColorType RGB_888X = null;
        public static final ColorType UNKNOWN = null;
        public static final /* synthetic */ ColorType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int index;
        private final String value;

        public static EnumEntries<ColorType> getEntries() {
            return b;
        }

        static {
            ColorType r0 = new ColorType("UNKNOWN", 0, InvRouter.UNKNOWN, 0);
            UNKNOWN = r0;
            ColorType r1 = new ColorType("ALPHA_8", 1, "alpha_8", 1);
            ALPHA_8 = r1;
            ColorType r2 = new ColorType("RGB_565", 2, "rgb_565", 2);
            RGB_565 = r2;
            ColorType r4 = new ColorType("ARGB_444", 3, "argb_444", 3);
            ARGB_444 = r4;
            ColorType r6 = new ColorType("RGBA_8888", 4, "rgba_8888", 4);
            RGBA_8888 = r6;
            ColorType r8 = new ColorType("RGB_888X", 5, "rgb_888x", 5);
            RGB_888X = r8;
            ColorType[] r10 = {r0, r1, r2, r4, r6, r8};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static ColorType[] values() {
            return (ColorType[]) a.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getValue() {
            return this.value;
        }

        public static ColorType valueOf(String r1) {
            return (ColorType) r27.a.a(ColorType.class, r1);
        }

        public ColorType(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            this.value = r3;
            this.index = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$FromType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "IMAGE", "POST", "STICKER", "MEDIA", "AVATAR", "REATION", "CARD", "URL_PREVIEW", "COVER", "CHAT_HISTORY", "CHAT_ALBUM", "MEMO_PICTURE", "ICON", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum FromType extends Enum<FromType> {
        public static final FromType AVATAR = null;
        public static final FromType CARD = null;
        public static final FromType CHAT_ALBUM = null;
        public static final FromType CHAT_HISTORY = null;
        public static final FromType COVER = null;
        public static final FromType ICON = null;
        public static final FromType IMAGE = null;
        public static final FromType MEDIA = null;
        public static final FromType MEMO_PICTURE = null;
        public static final FromType POST = null;
        public static final FromType REATION = null;
        public static final FromType STICKER = null;
        public static final FromType UNKNOWN = null;
        public static final FromType URL_PREVIEW = null;
        public static final /* synthetic */ FromType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<FromType> getEntries() {
            return b;
        }

        static {
            FromType r0 = new FromType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            FromType r1 = new FromType("IMAGE", 1, 1);
            IMAGE = r1;
            FromType r3 = new FromType("POST", 2, 2);
            POST = r3;
            FromType r5 = new FromType("STICKER", 3, 3);
            STICKER = r5;
            FromType r7 = new FromType("MEDIA", 4, 4);
            MEDIA = r7;
            FromType r9 = new FromType("AVATAR", 5, 5);
            AVATAR = r9;
            FromType r11 = new FromType("REATION", 6, 6);
            REATION = r11;
            FromType r13 = new FromType("CARD", 7, 7);
            CARD = r13;
            FromType r15 = new FromType("URL_PREVIEW", 8, 8);
            URL_PREVIEW = r15;
            FromType r14 = new FromType("COVER", 9, 9);
            COVER = r14;
            FromType r12 = new FromType("CHAT_HISTORY", 10, 10);
            CHAT_HISTORY = r12;
            FromType r10 = new FromType("CHAT_ALBUM", 11, 11);
            CHAT_ALBUM = r10;
            FromType r8 = new FromType("MEMO_PICTURE", 12, 12);
            MEMO_PICTURE = r8;
            FromType r6 = new FromType("ICON", 13, 13);
            ICON = r6;
            FromType[] r4 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static FromType[] values() {
            return (FromType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FromType valueOf(String r1) {
            return (FromType) r27.a.a(FromType.class, r1);
        }

        public FromType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NET", "DISK_CACHE", "MEMORY_CACHE", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum LoadType extends Enum<LoadType> {
        public static final LoadType DISK_CACHE = null;
        public static final LoadType MEMORY_CACHE = null;
        public static final LoadType NET = null;
        public static final LoadType UNKNOWN = null;
        public static final /* synthetic */ LoadType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<LoadType> getEntries() {
            return b;
        }

        static {
            LoadType r0 = new LoadType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            LoadType r1 = new LoadType("NET", 1, 1);
            NET = r1;
            LoadType r3 = new LoadType("DISK_CACHE", 2, 2);
            DISK_CACHE = r3;
            LoadType r5 = new LoadType("MEMORY_CACHE", 3, 3);
            MEMORY_CACHE = r5;
            LoadType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static LoadType[] values() {
            return (LoadType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static LoadType valueOf(String r1) {
            return (LoadType) r27.a.a(LoadType.class, r1);
        }

        public LoadType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public boolean a;
        public boolean b;
        public int c;
        public int d;
        public final int e;
        public final int f;
        public final int g;
        public b h;
        public Biz i;
        public Scene j;
        public FromType k;
        public final ChatType l;
        public final String m;
        public String n;
        public String o;
        public boolean p;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
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
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
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
            int r4 = (((((((((((r2 + r3) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
            b r5 = this.h;
            int r6 = 0;
            if (r5 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (((((((((r4 + r7) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
            String r9 = this.m;
            if (r9 != null) goto L17;
            int r10 = 0;
        L18:
            int r11 = (r8 + r10) * 31;
            String r12 = this.n;
            if (r12 != null) goto L21;
            int r13 = 0;
        L22:
            int r14 = (r11 + r13) * 31;
            String r15 = this.o;
            if (r15 == null) goto L26;
            r6 = r15.hashCode();
        L26:
            int r16 = (r14 + r6) * 31;
            if (this.p == true) goto L31;
            r1 = 1237;
        L31:
            return r16 + r1;
        L21:
            r13 = r12.hashCode();
            goto L22
        L17:
            r10 = r9.hashCode();
            goto L18
        L13:
            r7 = r5.hashCode();
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Builder(needLoadMonitor=" + this.a + ", isThumbnail=" + this.b + ", loadWidth=" + this.c + ", loadHeight=" + this.d + ", resourceWidth=" + this.e + ", resourceHeight=" + this.f + ", resourceFrames=" + this.g + ", requestListener=" + this.h + ", biz=" + this.i + ", scene=" + this.j + ", fromType=" + this.k + ", chatType=" + this.l + ", page=" + this.m + ", messageId=" + this.n + ", imageKey=" + this.o + ", isOrigin=" + this.p + ')';
        }

        public a() {
            Biz r0 = Biz.Messenger;
            Scene r1 = Scene.Chat;
            FromType r2 = FromType.UNKNOWN;
            ChatType r3 = ChatType.UNKNOWN;
            Intrinsics.checkNotNullParameter(r0, "biz");
            Intrinsics.checkNotNullParameter(r1, "scene");
            Intrinsics.checkNotNullParameter(r2, "fromType");
            Intrinsics.checkNotNullParameter(r3, "chatType");
            this.a = false;
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = null;
            this.i = r0;
            this.j = r1;
            this.k = r2;
            this.l = r3;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = false;
        }

        public final ListenerParams b() {
            return new ListenerParams(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
        }

        public final void a(Biz r2) {
            Intrinsics.checkNotNullParameter(r2, "biz");
            this.i = r2;
        }

        public final void c(FromType r2) {
            Intrinsics.checkNotNullParameter(r2, "fromType");
            this.k = r2;
        }

        public final void d(Scene r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.j = r2;
        }
    }

    public interface b {
        void a(Exception r1);

        void b(Object r1, Object r2, DataSource r3, boolean r4);
    }

    public ListenerParams(boolean r3, boolean r4, int r5, int r6, int r7, int r8, int r9, b r10, Biz r11, Scene r12, FromType r13, ChatType r14, String r15, String r16, String r17, boolean r18) {
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
