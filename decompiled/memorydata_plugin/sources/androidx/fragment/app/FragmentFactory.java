package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class FragmentFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = null;

    static {
        sClassCacheMap = new SimpleArrayMap();
    }

    public FragmentFactory() {
    }

    static boolean isFragmentClass(ClassLoader r0, String r1) {
        return Fragment.class.isAssignableFrom(loadClass(r0, r1));
    L4:
        return false;
    }

    private static Class<?> loadClass(ClassLoader r4, String r5) {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> r0 = sClassCacheMap;
        SimpleArrayMap<String, Class<?>> r1 = (SimpleArrayMap) ZeusTransformUtils.preCheckCast(r0.get(r4), SimpleArrayMap.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        r1 = new SimpleArrayMap();
        r0.put(r4, r1);
    L5:
        Class<?> r2 = (Class) ZeusTransformUtils.preCheckCast(r1.get(r5), Class.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        Class<?> r3 = Class.forName(r5, false, r4);
        r1.put(r5, r3);
        return r3;
    L9:
        return r2;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader r3, String r4) {
        return loadClass(r3, r4);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r4 + ": make sure class is a valid subclass of Fragment", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r4 + ": make sure class name exists", e);
    }

    public Fragment instantiate(ClassLoader r4, String r5) {
        return (Fragment) ZeusTransformUtils.preCheckCast(loadFragmentClass(r4, r5).getConstructor(new Class[0]).newInstance(new Object[0]), Fragment.class, "com.obric.memorydata.plugin");
    L11:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L14:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r5 + ": could not find Fragment constructor", e);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r5 + ": calling Fragment constructor caused an exception", e);
    }
}
