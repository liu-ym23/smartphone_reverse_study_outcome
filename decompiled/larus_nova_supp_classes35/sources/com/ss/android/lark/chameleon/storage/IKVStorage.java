package com.ss.android.lark.chameleon.storage;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/storage/IKVStorage;", BuildConfig.FLAVOR, "getBoolean", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "defaultValue", "getString", "put", BuildConfig.FLAVOR, "value", "putBoolean", "putString", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IKVStorage {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void put(IKVStorage r1, String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            if ((r3 instanceof String) == false) goto L6;
            r1.putString(r2, (String) r3);
            return;
        L6:
            if ((r3 instanceof Boolean) == false) goto L10;
            r1.putBoolean(r2, ((Boolean) r3).booleanValue());
            return;
        }

        public static /* synthetic */ boolean getBoolean$default(IKVStorage r0, String r1, boolean r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L7;
            r2 = false;
        L7:
            return r0.getBoolean(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
        }

        public static /* synthetic */ String getString$default(IKVStorage r0, String r1, String r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L7;
            r2 = BuildConfig.FLAVOR;
        L7:
            return r0.getString(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
        }
    }

    boolean getBoolean(String r1, boolean r2);

    String getString(String r1, String r2);

    void put(String r1, Object r2);

    void putBoolean(String r1, boolean r2);

    void putString(String r1, String r2);
}
