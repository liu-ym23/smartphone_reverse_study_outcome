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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/statistics/CreateGroupExtraParams$IsChangeAvatar;", "Lcom/ss/android/lark/statistics/extensions/IParam;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "FALSE", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupExtraParams$IsChangeAvatar extends Enum<CreateGroupExtraParams$IsChangeAvatar> implements d {
    public static final CreateGroupExtraParams$IsChangeAvatar FALSE = null;
    public static final /* synthetic */ CreateGroupExtraParams$IsChangeAvatar[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String key;
    private final String value;

    public CreateGroupExtraParams$IsChangeAvatar() {
        throw null;
    }

    public static EnumEntries<CreateGroupExtraParams$IsChangeAvatar> getEntries() {
        return b;
    }

    static {
        CreateGroupExtraParams$IsChangeAvatar r7 = new CreateGroupExtraParams$IsChangeAvatar("FALSE", 0, "false", null, 2, null);
        FALSE = r7;
        CreateGroupExtraParams$IsChangeAvatar[] r0 = {r7};
        a = r0;
        b = EnumEntriesKt.enumEntries(r0);
    }

    public static CreateGroupExtraParams$IsChangeAvatar[] values() {
        return (CreateGroupExtraParams$IsChangeAvatar[]) a.clone();
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

    public static CreateGroupExtraParams$IsChangeAvatar valueOf(String r1) {
        return (CreateGroupExtraParams$IsChangeAvatar) a.a(CreateGroupExtraParams$IsChangeAvatar.class, r1);
    }

    public d plus(Map<String, ? extends Object> r1) {
        return d.b.a(this, r1);
    }

    public d plus(d r1) {
        return d.b.b(this, r1);
    }

    public CreateGroupExtraParams$IsChangeAvatar(String r1, int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = "is_change_avatar";
    L5:
        super(r1, r2);
        this.value = r3;
        this.key = r4;
    }
}
