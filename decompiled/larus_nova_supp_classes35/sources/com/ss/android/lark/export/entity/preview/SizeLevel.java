package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/SizeLevel;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "NORMAL", "SMALL", "LARGE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SizeLevel extends Enum<SizeLevel> implements Serializable {
    public static final a Companion = null;
    public static final SizeLevel LARGE = null;
    public static final SizeLevel NORMAL = null;
    public static final SizeLevel SMALL = null;
    public static final /* synthetic */ SizeLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SizeLevel> getEntries() {
        return b;
    }

    static {
        SizeLevel r0 = new SizeLevel("NORMAL", 0, 0);
        NORMAL = r0;
        SizeLevel r1 = new SizeLevel("SMALL", 1, 1);
        SMALL = r1;
        SizeLevel r3 = new SizeLevel("LARGE", 2, 2);
        LARGE = r3;
        SizeLevel[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static SizeLevel[] values() {
        return (SizeLevel[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SizeLevel valueOf(String r1) {
        return (SizeLevel) r27.a.a(SizeLevel.class, r1);
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public SizeLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
