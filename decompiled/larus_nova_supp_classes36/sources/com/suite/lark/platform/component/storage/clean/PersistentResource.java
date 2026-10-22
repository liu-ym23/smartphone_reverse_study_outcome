package com.suite.lark.platform.component.storage.clean;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface PersistentResource extends f {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/PersistentResource$PersistentResourceAdapter;", "Lcom/google/gson/TypeAdapter;", "", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class PersistentResourceAdapter extends TypeAdapter<List<? extends PersistentResource>> {
        public static final PersistentResourceAdapter a = null;
        public static final Gson b = null;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[JsonToken.values().length];
                r0[JsonToken.BEGIN_OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        static {
            a = new PersistentResourceAdapter();
            b = new Gson();
        }

        private PersistentResourceAdapter() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }

        public final Object read(JsonReader r5) {
            Intrinsics.checkNotNullParameter(r5, "reader");
            ArrayList r0 = new ArrayList();
            r5.beginArray();
        L4:
            if (r5.hasNext() == false) goto L25;
            JsonToken r1 = r5.peek();
            if (r1 != null) goto L8;
            int r2 = -1;
        L10:
            if (r2 != 1) goto L4;
            r5.beginObject();
            String r3 = null;
        L13:
            if (r5.hasNext() == false) goto L24;
            String r4 = r5.nextName();
            if (Intrinsics.areEqual(r4, "type") == true) goto L16;
            if (Intrinsics.areEqual(r4, "value") == false) goto L13;
            Object r6 = b.fromJson(r5, a(r3));     // Catch: Exception -> L21
            Intrinsics.checkNotNull(r6);     // Catch: Exception -> L21
            r0.add((PersistentResource) r6);
        L21:
            e = move-exception;
            throw new IllegalStateException(e);
        L16:
            r3 = r5.nextString();
        L24:
            r5.endObject();
            goto L4
        L8:
            r2 = a.a[r1.ordinal()];
            goto L10
        L25:
            r5.endArray();
            return r0;
        }

        public final void write(JsonWriter r4, Object r5) {
            List r6 = (List) r5;
            Intrinsics.checkNotNullParameter(r4, "out");
            r4.beginArray();
            if (r6 == null) goto L16;
            Iterator r7 = r6.iterator();
        L6:
            if (r7.hasNext() == false) goto L16;
            PersistentResource r0 = (PersistentResource) r7.next();
            if (r0 == null) goto L9;
            r4.beginObject();
            r4.name("type").value(r0.getClass().getName());
            r4.name("value");
            b.toJson(r0, r0.getClass(), r4);     // Catch: Exception -> L13
            r4.endObject();
        L13:
            e = move-exception;
            throw new IllegalStateException(e);
        L9:
            r4.nullValue();
        L16:
            r4.endArray();
        }
    }
}
