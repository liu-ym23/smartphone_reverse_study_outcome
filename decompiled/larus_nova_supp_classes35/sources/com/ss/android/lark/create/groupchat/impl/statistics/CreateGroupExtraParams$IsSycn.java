package com.ss.android.lark.create.groupchat.impl.statistics;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/statistics/CreateGroupExtraParams$IsSycn;", "Lcom/ss/android/lark/statistics/extensions/IParam;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "TRUE", "FALSE", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupExtraParams$IsSycn extends Enum<CreateGroupExtraParams$IsSycn> implements d {
    public static final CreateGroupExtraParams$IsSycn FALSE = null;
    public static final CreateGroupExtraParams$IsSycn TRUE = null;
    public static final /* synthetic */ CreateGroupExtraParams$IsSycn[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String key;
    private final String value;

    public CreateGroupExtraParams$IsSycn() {
        throw null;
    }

    public static EnumEntries<CreateGroupExtraParams$IsSycn> getEntries() {
        return b;
    }

    static {
        CreateGroupExtraParams$IsSycn r7 = new CreateGroupExtraParams$IsSycn("TRUE", 0, "true", null, 2, null);
        TRUE = r7;
        CreateGroupExtraParams$IsSycn r0 = new CreateGroupExtraParams$IsSycn("FALSE", 1, "false", null, 2, null);
        FALSE = r0;
        CreateGroupExtraParams$IsSycn[] r1 = {r7, r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public static CreateGroupExtraParams$IsSycn[] values() {
        return (CreateGroupExtraParams$IsSycn[]) a.clone();
    }

    public JSONObject toJson() {
        return d.b.c(this);
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public static CreateGroupExtraParams$IsSycn valueOf(String r1) {
        return (CreateGroupExtraParams$IsSycn) a.a(CreateGroupExtraParams$IsSycn.class, r1);
    }

    public d plus(Map<String, ? extends Object> r1) {
        return d.b.a(this, r1);
    }

    public d plus(d r1) {
        return d.b.b(this, r1);
    }

    public CreateGroupExtraParams$IsSycn(String r1, int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = "is_sycn";
    L5:
        super(r1, r2);
        this.value = r3;
        this.key = r4;
    }
}
