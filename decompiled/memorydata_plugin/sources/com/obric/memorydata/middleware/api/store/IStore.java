package com.obric.memorydata.middleware.api.store;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH&J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000fH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\nH&J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\fH&J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u000bH&J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u000fH&J9\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0017H&¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\t2\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001d\"\u00020\u0003H&¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&J\b\u0010!\u001a\u00020\u0007H&J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&J\u0018\u0010%\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\nH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH&¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010*H&J\u0018\u0010+\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010+\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH&J\u0018\u0010+\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH&J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/H&¨\u00061"}, d2 = {"Lcom/obric/memorydata/middleware/api/store/IStore;", "", "getString", "", "key", "defaultValue", "save", "", EventBody.KEY_VALUE, "", "", "", "", "values", "", "", "Landroid/os/Parcelable;", "getBoolean", "getInt", "getFloat", "getLong", "getDouble", "getParcelable", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "remove", "keys", "", "([Ljava/lang/String;)Z", "saveStringSet", "getStringSet", "clearAll", "saveBooleanArray", "array", "", "getBooleanArray", "arrayLength", "allKeys", "()[Ljava/lang/String;", "dumpAll", "", "syncSave", "contains", "registerChangeListener", "listener", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "unregisterChangeListener", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IStore {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ double a(IStore r2, String r3, double r4, int r6, Object r7) {
            IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = 0.0d;
        L8:
            return r5.getDouble(r3, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDouble");
        }

        public static /* synthetic */ float a(IStore r2, String r3, float r4, int r5, Object r6) {
            IStore r7 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L8;
            r4 = 0.0f;
        L8:
            return r7.getFloat(r3, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloat");
        }

        public static /* synthetic */ long a(IStore r2, String r3, long r4, int r6, Object r7) {
            IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = 0;
        L8:
            return r5.getLong(r3, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
        }
    }

    String[] allKeys();

    void clearAll();

    boolean contains(String r1);

    Map<String, Object> dumpAll();

    boolean getBoolean(String r1);

    boolean getBoolean(String r1, boolean r2);

    boolean[] getBooleanArray(String r1, int r2);

    double getDouble(String r1, double r2);

    float getFloat(String r1, float r2);

    int getInt(String r1);

    int getInt(String r1, int r2);

    long getLong(String r1, long r2);

    <T extends Parcelable> T getParcelable(String r1, Class<T> r2, T r3);

    String getString(String r1);

    String getString(String r1, String r2);

    Set<String> getStringSet(String r1, Set<String> r2);

    void registerChangeListener(b r1);

    boolean remove(String... r1);

    void save(String r1, double r2);

    void save(String r1, float r2);

    void save(String r1, int r2);

    void save(String r1, long r2);

    void save(String r1, Parcelable r2);

    void save(String r1, String r2);

    void save(String r1, Set<String> r2);

    void save(String r1, boolean r2);

    void saveBooleanArray(String r1, boolean[] r2);

    void saveStringSet(String r1, Set<String> r2);

    boolean syncSave(String r1, int r2);

    boolean syncSave(String r1, long r2);

    boolean syncSave(String r1, String r2);

    void unregisterChangeListener(b r1);
}
