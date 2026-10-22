package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TABLE_NAME_PLACEHOLDER", "", "VIEW_NAME_PLACEHOLDER", "replaceTableName", "contents", "tableName", "replaceViewName", "viewName", "room-migration"}, k = 2, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "BundleUtil")
public final class BundleUtil {
    public static final String TABLE_NAME_PLACEHOLDER = "${TABLE_NAME}";
    public static final String VIEW_NAME_PLACEHOLDER = "${VIEW_NAME}";

    public static final String replaceTableName(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "contents");
        Intrinsics.checkNotNullParameter(r10, "tableName");
        return StringsKt.F(r5, TABLE_NAME_PLACEHOLDER, r10);
    }

    public static final String replaceViewName(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "contents");
        Intrinsics.checkNotNullParameter(r10, "viewName");
        return StringsKt.F(r5, VIEW_NAME_PLACEHOLDER, r10);
    }
}
