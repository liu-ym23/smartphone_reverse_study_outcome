package com.ss.android.lark.chat.entity.chatter;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/TagType;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "order", BuildConfig.FLAVOR, "bgColor", "textColor", "<init>", "(Ljava/lang/String;IIII)V", "getOrder", "()I", "getBgColor", "getTextColor", "UNKNOWN", "CLASS_TEACHER", "DISCIPLINE_TEACHER", "ADMIN_USER", "KA", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TagType extends Enum<TagType> implements Serializable {
    public static final TagType ADMIN_USER = null;
    public static final TagType CLASS_TEACHER = null;
    public static final TagType DISCIPLINE_TEACHER = null;
    public static final TagType KA = null;
    public static final TagType UNKNOWN = null;
    public static final /* synthetic */ TagType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int bgColor;
    private final int order;
    private final int textColor;

    public static EnumEntries<TagType> getEntries() {
        return b;
    }

    static {
        TagType r6 = new TagType("UNKNOWN", 0, 0, 2131109109, 2131109115);
        UNKNOWN = r6;
        TagType r0 = new TagType("CLASS_TEACHER", 1, 100, 2131109083, 2131109125);
        CLASS_TEACHER = r0;
        TagType r1 = new TagType("DISCIPLINE_TEACHER", 2, 100, 2131109099, 2131109133);
        DISCIPLINE_TEACHER = r1;
        TagType r2 = new TagType("ADMIN_USER", 3, 50, 2131109095, 2131109131);
        ADMIN_USER = r2;
        TagType r3 = new TagType("KA", 4, 0, 2131109097, 2131109132);
        KA = r3;
        TagType[] r4 = {r6, r0, r1, r2, r3};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static TagType[] values() {
        return (TagType[]) a.clone();
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public static TagType valueOf(String r1) {
        return (TagType) r27.a.a(TagType.class, r1);
    }

    public TagType(String r1, int r2, int r3, int r4, int r5) {
        super(r1, r2);
        this.order = r3;
        this.bgColor = r4;
        this.textColor = r5;
    }
}
