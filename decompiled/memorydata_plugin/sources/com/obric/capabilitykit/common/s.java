package com.obric.capabilitykit.common;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ConditionType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TIME", "LOCATION", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum s extends Enum<s> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f7520b = null;
    public static final s c = null;
    private static final /* synthetic */ s[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7521a;

    static {
        f7520b = new s("TIME", 0, OaidModel.KEY_TIME);
        c = new s("LOCATION", 1, "location");
        d = a();
    }

    private s(String r1, int r2, String r3) {
        super(r1, r2);
        this.f7521a = r3;
    }

    private static final /* synthetic */ s[] a() {
        return new s[]{f7520b, c};
    }

    public static s valueOf(String r2) {
        return (s) ZeusTransformUtils.preCheckCast(Enum.valueOf(s.class, r2), s.class, "com.obric.memorydata.plugin");
    }

    public static s[] values() {
        return (s[]) ZeusTransformUtils.preCheckCast(d.clone(), s[].class, "com.obric.memorydata.plugin");
    }

    public final String b() {
        return this.f7521a;
    }
}
