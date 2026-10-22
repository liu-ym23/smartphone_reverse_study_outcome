package com.ss.android.lark.export.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/entity/WidthMode;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COMPACT", "SPACIOUS", "FILL", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WidthMode extends Enum<WidthMode> {
    public static final WidthMode COMPACT = null;
    public static final a Companion = null;
    public static final WidthMode FILL = null;
    public static final WidthMode SPACIOUS = null;
    public static final /* synthetic */ WidthMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static WidthMode a(String r2) {
            WidthMode r0 = WidthMode.SPACIOUS;
            if (Intrinsics.areEqual(r2, r0.getValue()) == true) goto L10;
            WidthMode r1 = WidthMode.FILL;
            if (Intrinsics.areEqual(r2, r1.getValue()) == false) goto L9;
            return r1;
        L9:
            return WidthMode.COMPACT;
        L10:
            return r0;
        }
    }

    @JvmStatic
    public static final WidthMode forString(String r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<WidthMode> getEntries() {
        return b;
    }

    static {
        WidthMode r0 = new WidthMode("COMPACT", 0, "compact");
        COMPACT = r0;
        WidthMode r1 = new WidthMode("SPACIOUS", 1, "spacious");
        SPACIOUS = r1;
        WidthMode r3 = new WidthMode("FILL", 2, "fill");
        FILL = r3;
        WidthMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static WidthMode[] values() {
        return (WidthMode[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static WidthMode valueOf(String r1) {
        return (WidthMode) r27.a.a(WidthMode.class, r1);
    }

    public WidthMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
