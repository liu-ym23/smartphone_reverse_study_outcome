package com.ss.android.lark.ding.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/ding/entity/DingReadState;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "NONE", "READ", "UN_READ", "getValue", "Companion", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DingReadState extends Enum<DingReadState> {
    public static final a Companion = null;
    public static final DingReadState NONE = null;
    public static final DingReadState READ = null;
    public static final DingReadState UN_READ = null;
    public static final /* synthetic */ DingReadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DingReadState> getEntries() {
        return b;
    }

    static {
        DingReadState r0 = new DingReadState("NONE", 0, 0);
        NONE = r0;
        DingReadState r1 = new DingReadState("READ", 1, 1);
        READ = r1;
        DingReadState r3 = new DingReadState("UN_READ", 2, 2);
        UN_READ = r3;
        DingReadState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static DingReadState[] values() {
        return (DingReadState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DingReadState valueOf(String r1) {
        return (DingReadState) r27.a.a(DingReadState.class, r1);
    }

    public DingReadState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
