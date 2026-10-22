package com.larus.camera.impl.edulibs.camera.internal.idl;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/idl/BusinessType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UnknownBusiness", "Hippo", "Doubao", "Douyin", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BusinessType extends Enum<BusinessType> {
    public static final a Companion = null;

    @SerializedName("2")
    public static final BusinessType Doubao = null;

    @SerializedName("3")
    public static final BusinessType Douyin = null;

    @SerializedName("1")
    public static final BusinessType Hippo = null;

    @SerializedName(TriggerSendLoading.NO_LOADING)
    public static final BusinessType UnknownBusiness = null;
    public static final /* synthetic */ BusinessType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BusinessType> getEntries() {
        return b;
    }

    static {
        BusinessType r0 = new BusinessType("UnknownBusiness", 0, 0);
        UnknownBusiness = r0;
        BusinessType r1 = new BusinessType("Hippo", 1, 1);
        Hippo = r1;
        BusinessType r3 = new BusinessType("Doubao", 2, 2);
        Doubao = r3;
        BusinessType r5 = new BusinessType("Douyin", 3, 3);
        Douyin = r5;
        BusinessType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static BusinessType[] values() {
        return (BusinessType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BusinessType findByValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return null;
    L17:
        return Douyin;
    L18:
        return Doubao;
    L19:
        return Hippo;
    L15:
        return UnknownBusiness;
    }

    public static BusinessType valueOf(String r1) {
        return (BusinessType) r27.a.a(BusinessType.class, r1);
    }

    public BusinessType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
