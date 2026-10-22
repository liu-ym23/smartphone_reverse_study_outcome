package bs;

import com.obric.oui.pullrefresh.RefreshState;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f983a = null;

    static {
        int[] r5 = new int[RefreshState.values().length];
        r5[RefreshState.PULL_TO_REFRESH.ordinal()] = 1;
        r5[RefreshState.IDLE.ordinal()] = 2;
        r5[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
        r5[RefreshState.REFRESHING.ordinal()] = 4;
        r5[RefreshState.FINISH.ordinal()] = 5;
        f983a = r5;
    }
}
