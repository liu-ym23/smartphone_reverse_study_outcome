package com.bytedance.android.live.revlink.impl.multianchor.constants;

import h21.b;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "", "", "toString", "", "toJsbPkMode", "toNetFormat", "PERSONAL_PK", "TEAM_PK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayMode extends Enum<PlayMode> {
    public static final PlayMode PERSONAL_PK = null;
    public static final PlayMode TEAM_PK = null;
    public static final /* synthetic */ PlayMode[] a = null;

    static {
        PlayMode r1 = new PlayMode("PERSONAL_PK", 0);
        PERSONAL_PK = r1;
        PlayMode r2 = new PlayMode("TEAM_PK", 1);
        TEAM_PK = r2;
        a = new PlayMode[]{r1, r2};
    }

    public static PlayMode valueOf(String r1) {
        return (PlayMode) a.a(PlayMode.class, r1);
    }

    public static PlayMode[] values() {
        return (PlayMode[]) a.clone();
    }

    public final int toJsbPkMode() {
        if (this != PERSONAL_PK) goto L7;
        return 1;
    L7:
        if (this != TEAM_PK) goto L10;
        return 2;
    L10:
        return 0;
    }

    public final int toNetFormat() {
        int r0 = b.a[ordinal()];
        if (r0 != 1) goto L5;
        return 1;
    L5:
        if (r0 == 2) goto L9;
        return 0;
    L9:
        return 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != PERSONAL_PK) goto L7;
        return "personal_pk";
    L7:
        if (this != TEAM_PK) goto L10;
        return "team_pk";
    L10:
        return "unknown";
    }

    public PlayMode(String r1, int r2) {
        super(r1, r2);
    }
}
