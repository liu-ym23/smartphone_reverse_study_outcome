package com.bytedance.android.live.revlink.impl.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/constants/RandomMatchCheckSource;", "", "Setting", "CheckFragment", "AttentionFragment", "PKUserListFragment", "MultiPKUserListFragment", "TOPBANNER", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RandomMatchCheckSource extends Enum<RandomMatchCheckSource> {
    public static final RandomMatchCheckSource AttentionFragment = null;
    public static final RandomMatchCheckSource CheckFragment = null;
    public static final RandomMatchCheckSource MultiPKUserListFragment = null;
    public static final RandomMatchCheckSource PKUserListFragment = null;
    public static final RandomMatchCheckSource Setting = null;
    public static final RandomMatchCheckSource TOPBANNER = null;
    public static final /* synthetic */ RandomMatchCheckSource[] a = null;

    static {
        RandomMatchCheckSource r1 = new RandomMatchCheckSource("Setting", 0);
        Setting = r1;
        RandomMatchCheckSource r2 = new RandomMatchCheckSource("CheckFragment", 1);
        CheckFragment = r2;
        RandomMatchCheckSource r3 = new RandomMatchCheckSource("AttentionFragment", 2);
        AttentionFragment = r3;
        RandomMatchCheckSource r4 = new RandomMatchCheckSource("PKUserListFragment", 3);
        PKUserListFragment = r4;
        RandomMatchCheckSource r5 = new RandomMatchCheckSource("MultiPKUserListFragment", 4);
        MultiPKUserListFragment = r5;
        RandomMatchCheckSource r6 = new RandomMatchCheckSource("TOPBANNER", 5);
        TOPBANNER = r6;
        a = new RandomMatchCheckSource[]{r1, r2, r3, r4, r5, r6};
    }

    public static RandomMatchCheckSource valueOf(String r1) {
        return (RandomMatchCheckSource) a.a(RandomMatchCheckSource.class, r1);
    }

    public static RandomMatchCheckSource[] values() {
        return (RandomMatchCheckSource[]) a.clone();
    }

    public RandomMatchCheckSource(String r1, int r2) {
        super(r1, r2);
    }
}
