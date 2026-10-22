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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/statistics/CreateGroupExtraParams$Source;", "Lcom/ss/android/lark/statistics/extensions/IParam;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "PLUS", "FROM_FORWARD", "FROM_P2P", "FROM_INNER_GROUP", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupExtraParams$Source extends Enum<CreateGroupExtraParams$Source> implements d {
    public static final CreateGroupExtraParams$Source FROM_FORWARD = null;
    public static final CreateGroupExtraParams$Source FROM_INNER_GROUP = null;
    public static final CreateGroupExtraParams$Source FROM_P2P = null;
    public static final CreateGroupExtraParams$Source PLUS = null;
    public static final /* synthetic */ CreateGroupExtraParams$Source[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String key;
    private final String value;

    public CreateGroupExtraParams$Source() {
        throw null;
    }

    public static EnumEntries<CreateGroupExtraParams$Source> getEntries() {
        return b;
    }

    static {
        CreateGroupExtraParams$Source r7 = new CreateGroupExtraParams$Source("PLUS", 0, "plus", null, 2, null);
        PLUS = r7;
        CreateGroupExtraParams$Source r0 = new CreateGroupExtraParams$Source("FROM_FORWARD", 1, "from_forward", null, 2, null);
        FROM_FORWARD = r0;
        CreateGroupExtraParams$Source r1 = new CreateGroupExtraParams$Source("FROM_P2P", 2, "from_p2p", null, 2, null);
        FROM_P2P = r1;
        CreateGroupExtraParams$Source r2 = new CreateGroupExtraParams$Source("FROM_INNER_GROUP", 3, "from_inner_group", null, 2, null);
        FROM_INNER_GROUP = r2;
        CreateGroupExtraParams$Source[] r3 = {r7, r0, r1, r2};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static CreateGroupExtraParams$Source[] values() {
        return (CreateGroupExtraParams$Source[]) a.clone();
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

    public static CreateGroupExtraParams$Source valueOf(String r1) {
        return (CreateGroupExtraParams$Source) a.a(CreateGroupExtraParams$Source.class, r1);
    }

    public d plus(Map<String, ? extends Object> r1) {
        return d.b.a(this, r1);
    }

    public d plus(d r1) {
        return d.b.b(this, r1);
    }

    public CreateGroupExtraParams$Source(String r1, int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = "source";
    L5:
        super(r1, r2);
        this.value = r3;
        this.key = r4;
    }
}
