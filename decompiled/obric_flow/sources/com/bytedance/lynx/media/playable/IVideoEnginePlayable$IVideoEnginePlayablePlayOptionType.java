package com.bytedance.lynx.media.playable;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/lynx/media/playable/IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType", "", "Lcom/bytedance/lynx/media/playable/IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType;", "x-element-media_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType extends Enum<IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType f6823a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType f6824b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType f6825c = null;
    public static final IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType d = null;
    public static final /* synthetic */ IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType[] e = null;

    static {
        IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType r5 = new IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType("TYPE_STRING", 0);
        f6823a = r5;
        IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType r10 = new IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType("TYPE_INT", 1);
        f6824b = r10;
        IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType r11 = new IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType("TYPE_LONG", 2);
        f6825c = r11;
        IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType r12 = new IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType("TYPE_FLOAT", 3);
        d = r12;
        e = new IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType[]{r5, r10, r11, r12};
    }

    public IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType(String r5, int r10) {
        super(r5, r10);
    }

    public static IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType valueOf(String r5) {
        return (IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType) Enum.valueOf(IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType.class, r5);
    }

    public static IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType[] values() {
        return (IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType[]) e.clone();
    }
}
