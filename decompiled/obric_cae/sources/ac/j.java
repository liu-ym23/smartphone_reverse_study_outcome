package ac;

import android.media.SoundPool;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements SoundPool.OnLoadCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f321a = null;

    static {
        f321a = new j();
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool r8, int r10, int r11) {
        if (r11 != 0) goto L22;
        SoundPool r12 = k.f322a;
        Set<Map.Entry<Integer, Integer>> r13 = k.f323b.entrySet();
        he.i.e(r13, "soundIdMap.entries");
        Iterator<T> r14 = r13.iterator();
    L5:
        Integer r15 = null;
        if (r14.hasNext() == false) goto L16;
        Object r16 = r14.next();
        Integer r17 = (Integer) ((Map.Entry) r16).getValue();
        if (r17 != null) goto L11;
    L13:
        boolean r18 = false;
    L14:
        if (r18 == false) goto L5;
    L17:
        Map.Entry r19 = (Map.Entry) r16;
        if (r19 == null) goto L20;
        r15 = (Integer) r19.getKey();
    L20:
        if (r15 == null) goto L29;
        SoundPool r20 = k.f322a;
        k.f324c.add(r15);
        zc.b.a("OUISoundEffectHelper", "loaded: resId=" + r15);
        return;
    L29:
        return;
    L11:
        if (r17.intValue() != r10) goto L13;
        r18 = true;
        goto L14
    L16:
        r16 = null;
        goto L17
    L22:
        zc.b.b("OUISoundEffectHelper", "load failed, sampleId=" + r10 + ", status=" + r11);
    }
}
