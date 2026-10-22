package r98;

import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaLifecycleState.values().length];
            r0[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[MediaLifecycleState.PROCESSING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[MediaLifecycleState.PROCESSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[MediaLifecycleState.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[MediaLifecycleState.COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[MediaLifecycleState.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public static final boolean a(MediaMetadata r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        MediaLifecycleState r2 = r1.getLifecycleState();
        switch(a.a[r2.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
