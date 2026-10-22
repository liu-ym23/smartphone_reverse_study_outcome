package com.bytedance.android.ec.core.event;

import com.bytedance.android.ec.core.event.eventdumper.EventParamProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseEventContext {
    private final HashMap<String, String> extraParams;
    private final HashMap<String, b> paramsMap;

    public final class a implements b {
        public final Field a;
        public final /* synthetic */ BaseEventContext b;

        @Override // com.bytedance.android.ec.core.event.BaseEventContext.b
        public final Object getValue() {
            return this.a.get(this.b);
        }

        public a(BaseEventContext r10, Field r11) {
            Intrinsics.checkNotNullParameter(r11, "field");
            this.b = r10;
            this.a = r11;
            r11.setAccessible(true);
        }
    }

    public interface b {
        Object getValue();
    }

    public final class c implements b {
        public final Method a;
        public final /* synthetic */ BaseEventContext b;

        @Override // com.bytedance.android.ec.core.event.BaseEventContext.b
        public final Object getValue() {
            return this.a.invoke(this.b, new Object[0]);
        }

        public c(BaseEventContext r10, Method r11) {
            Intrinsics.checkNotNullParameter(r11, "method");
            this.b = r10;
            this.a = r11;
            r11.setAccessible(true);
        }
    }

    public BaseEventContext() {
        this.paramsMap = new HashMap();
        this.extraParams = new HashMap();
        Field[] r0 = getClass().getDeclaredFields();
        int r1 = r0.length;
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L11;
        Field r12 = r0[r11];
        Iterator r13 = ArrayIteratorKt.iterator(r12.getDeclaredAnnotations());
    L6:
        if (r13.hasNext() == false) goto L10;
        Annotation r14 = (Annotation) r13.next();
        if ((r14 instanceof EventParamProvider) == false) goto L6;
        this.paramsMap.put(((EventParamProvider) r14).value(), new a(this, r12));
        goto L6
    L10:
        r11 = r11 + 1;
        goto L3
    L11:
        Method[] r15 = getClass().getDeclaredMethods();
        int r16 = r15.length;
    L12:
        if (r10 >= r16) goto L20;
        Method r17 = r15[r10];
        Iterator r18 = ArrayIteratorKt.iterator(r17.getDeclaredAnnotations());
    L15:
        if (r18.hasNext() == false) goto L19;
        Annotation r19 = (Annotation) r18.next();
        if ((r19 instanceof EventParamProvider) == false) goto L15;
        this.paramsMap.put(((EventParamProvider) r19).value(), new c(this, r17));
        goto L15
    L19:
        r10 = r10 + 1;
        goto L12
    }

    public final HashMap<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final HashMap<String, b> getParamsMap() {
        return this.paramsMap;
    }

    public final void post(final String r10, final Map<String, String>... r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "params");
        new AnonymousClass1(r11, r10, r10).with(new BaseEventContext[]{this}).post(null, null);
    }
}
