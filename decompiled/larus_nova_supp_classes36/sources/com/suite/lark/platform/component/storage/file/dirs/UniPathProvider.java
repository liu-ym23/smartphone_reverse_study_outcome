package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface UniPathProvider {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/suite/lark/platform/component/storage/file/dirs/UniPathProvider$SpaceType;", "", "<init>", "(Ljava/lang/String;I)V", "LARK", "USER", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum SpaceType extends Enum<SpaceType> {
        public static final SpaceType LARK = null;
        public static final SpaceType USER = null;
        public static final /* synthetic */ SpaceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SpaceType> getEntries() {
            return b;
        }

        static {
            SpaceType r0 = new SpaceType("LARK", 0);
            LARK = r0;
            SpaceType r1 = new SpaceType("USER", 1);
            USER = r1;
            SpaceType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static SpaceType[] values() {
            return (SpaceType[]) a.clone();
        }

        public static SpaceType valueOf(String r1) {
            return (SpaceType) r27.a.a(SpaceType.class, r1);
        }

        public SpaceType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static FileStorage a(UniPathProvider r1) {
            SpaceType r2 = r1.c();
            int r3 = b.a[r2.ordinal()];
            if (r3 == 1) goto L10;
            if (r3 != 2) goto L8;
            return LarkFileStorage.c();
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return LarkFileStorage.b();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SpaceType.values().length];
            r0[SpaceType.LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SpaceType.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    String a(Context r1);

    FileStorage b();

    SpaceType c();

    VFSPath d(FileStorage r1);
}
