package com.larus.xbridge.impl.choosemedia;

import android.content.Context;
import android.content.Intent;
import com.obric.aivoice.core.data.NameKeys;
import h4a.d;
import j4a.f;
import j4a.i;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class BDXFileSelectionMethodHelper implements f, ug9.a {
    public final WeakReference<Context> a;
    public i b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/xbridge/impl/choosemedia/BDXFileSelectionMethodHelper$FeatureType;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "TAKE_PHOTO", "PICK_PHOTO_FROM_ALBUM", "TAKE_VIDEO", "PICK_VIDEO_FROM_ALBUM", "PICK_PHOTO_AND_VIDEO_FROM_ALBUM", "UNSUPPORTED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeatureType extends Enum<FeatureType> {
        public static final a Companion = null;
        public static final FeatureType PICK_PHOTO_AND_VIDEO_FROM_ALBUM = null;
        public static final FeatureType PICK_PHOTO_FROM_ALBUM = null;
        public static final FeatureType PICK_VIDEO_FROM_ALBUM = null;
        public static final FeatureType TAKE_PHOTO = null;
        public static final FeatureType TAKE_VIDEO = null;
        public static final FeatureType UNSUPPORTED = null;
        public static final /* synthetic */ FeatureType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FeatureType> getEntries() {
            return b;
        }

        static {
            FeatureType r0 = new FeatureType("TAKE_PHOTO", 0);
            TAKE_PHOTO = r0;
            FeatureType r1 = new FeatureType("PICK_PHOTO_FROM_ALBUM", 1);
            PICK_PHOTO_FROM_ALBUM = r1;
            FeatureType r3 = new FeatureType("TAKE_VIDEO", 2);
            TAKE_VIDEO = r3;
            FeatureType r5 = new FeatureType("PICK_VIDEO_FROM_ALBUM", 3);
            PICK_VIDEO_FROM_ALBUM = r5;
            FeatureType r7 = new FeatureType("PICK_PHOTO_AND_VIDEO_FROM_ALBUM", 4);
            PICK_PHOTO_AND_VIDEO_FROM_ALBUM = r7;
            FeatureType r9 = new FeatureType("UNSUPPORTED", 5);
            UNSUPPORTED = r9;
            FeatureType[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
        }

        public static FeatureType[] values() {
            return (FeatureType[]) a.clone();
        }

        public static FeatureType valueOf(String r1) {
            return (FeatureType) r27.a.a(FeatureType.class, r1);
        }

        public FeatureType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeatureType.values().length];
            r0[FeatureType.PICK_VIDEO_FROM_ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[FeatureType.TAKE_VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[FeatureType.TAKE_PHOTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[FeatureType.PICK_PHOTO_FROM_ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[FeatureType.PICK_PHOTO_AND_VIDEO_FROM_ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public BDXFileSelectionMethodHelper(WeakReference<Context> r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        switch(r2) {
            case 1311210: goto L4;
            case 1311211: goto L4;
            case 1311212: goto L4;
            case 1311213: goto L4;
            case 1311214: goto L4;
            default: goto L3;
        };
    L3:
        ((d) this).onFailed(0, "Unrecognized request code");
        return;
    L4:
        i r0 = this.b;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mIFileMediaFeature");
        r0 = null;
    L7:
        r0.onActivityResult(r2, r3, r4);
    }
}
