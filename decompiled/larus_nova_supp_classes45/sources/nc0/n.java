package nc0;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LinkerKickOutContent.KickOutSource.values().length];
        a = r0;
        r0[LinkerKickOutContent.KickOutSource.Unknown.ordinal()] = 1;
        r0[LinkerKickOutContent.KickOutSource.FromOrganizer.ordinal()] = 2;
        r0[LinkerKickOutContent.KickOutSource.General.ordinal()] = 3;
        r0[LinkerKickOutContent.KickOutSource.RTCLeave.ordinal()] = 4;
        r0[LinkerKickOutContent.KickOutSource.RTCUnLink.ordinal()] = 5;
    }
}
