package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import com.bytedance.bdlocation.BuildConfig;
import f52.f;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/NativePSTopViewType;", BuildConfig.FLAVOR, "Lf52/f;", BuildConfig.FLAVOR, "priority", "I", "getPriority", "()I", BuildConfig.FLAVOR, "getDesc", "()Ljava/lang/String;", "desc", "HotMsgGather", "NewHotMsg", "BusinessMsg", "LikeEgg", "ChatCarnival", "MatchDynamicHotMsg", "Confront", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NativePSTopViewType extends Enum<NativePSTopViewType> implements f {
    public static final NativePSTopViewType BusinessMsg = null;
    public static final NativePSTopViewType ChatCarnival = null;
    public static final NativePSTopViewType Confront = null;
    public static final NativePSTopViewType HotMsgGather = null;
    public static final NativePSTopViewType LikeEgg = null;
    public static final NativePSTopViewType MatchDynamicHotMsg = null;
    public static final NativePSTopViewType NewHotMsg = null;
    public static final /* synthetic */ NativePSTopViewType[] a = null;
    private final int priority;

    static {
        NativePSTopViewType r1 = new NativePSTopViewType("HotMsgGather", 0, 0);
        HotMsgGather = r1;
        NativePSTopViewType r2 = new NativePSTopViewType("NewHotMsg", 1, 1);
        NewHotMsg = r2;
        NativePSTopViewType r3 = new NativePSTopViewType("BusinessMsg", 2, 40);
        BusinessMsg = r3;
        NativePSTopViewType r4 = new NativePSTopViewType("LikeEgg", 3, 50);
        LikeEgg = r4;
        NativePSTopViewType r5 = new NativePSTopViewType("ChatCarnival", 4, 100);
        ChatCarnival = r5;
        NativePSTopViewType r6 = new NativePSTopViewType("MatchDynamicHotMsg", 5, 75);
        MatchDynamicHotMsg = r6;
        NativePSTopViewType r7 = new NativePSTopViewType("Confront", 6, 100);
        Confront = r7;
        a = new NativePSTopViewType[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static NativePSTopViewType valueOf(String r1) {
        return (NativePSTopViewType) a.a(NativePSTopViewType.class, r1);
    }

    public static NativePSTopViewType[] values() {
        return (NativePSTopViewType[]) a.clone();
    }

    public String getDesc() {
        return name();
    }

    @Override // f52.f
    public int getPriority() {
        return this.priority;
    }

    public NativePSTopViewType(String r1, int r2, int r3) {
        super(r1, r2);
        this.priority = r3;
    }
}
