package com.ss.android.lark.keyboard.dtocompat;

import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UrlInlinePreviewEntity {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public final int h;
    public final int i;
    public final String j;
    public final String k;
    public final int l;
    public final boolean m;
    public LinkType n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity$UrlPreViewSourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "CHAT_ANNOUNCEMENT", "PERSONAL_SIG", "PRIVATE_DESCRIPTION", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum UrlPreViewSourceType extends Enum<UrlPreViewSourceType> {
        public static final UrlPreViewSourceType CHAT_ANNOUNCEMENT = null;
        public static final a Companion = null;
        public static final UrlPreViewSourceType PERSONAL_SIG = null;
        public static final UrlPreViewSourceType PRIVATE_DESCRIPTION = null;
        public static final /* synthetic */ UrlPreViewSourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<UrlPreViewSourceType> getEntries() {
            return b;
        }

        static {
            UrlPreViewSourceType r0 = new UrlPreViewSourceType("CHAT_ANNOUNCEMENT", 0, 1);
            CHAT_ANNOUNCEMENT = r0;
            UrlPreViewSourceType r1 = new UrlPreViewSourceType("PERSONAL_SIG", 1, 10);
            PERSONAL_SIG = r1;
            UrlPreViewSourceType r4 = new UrlPreViewSourceType("PRIVATE_DESCRIPTION", 2, 11);
            PRIVATE_DESCRIPTION = r4;
            UrlPreViewSourceType[] r5 = {r0, r1, r4};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static UrlPreViewSourceType[] values() {
            return (UrlPreViewSourceType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static UrlPreViewSourceType valueOf(String r1) {
            return (UrlPreViewSourceType) r27.a.a(UrlPreViewSourceType.class, r1);
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public UrlPreViewSourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public UrlInlinePreviewEntity(String r3, String r4, String r5, int r6, int r7, String r8, String r9, int r10, int r11, String r12, String r13, int r14, boolean r15) {
        LinkType r0 = LinkType.UrlInline;
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "iconKey");
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
        this.n = r0;
    }
}
