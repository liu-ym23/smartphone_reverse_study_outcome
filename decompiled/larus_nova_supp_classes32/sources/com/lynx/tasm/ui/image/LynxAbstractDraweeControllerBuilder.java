package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.lynx.tasm.ui.image.LynxAbstractDraweeControllerBuilder;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class LynxAbstractDraweeControllerBuilder<BUILDER extends LynxAbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {
    public static final a j = null;
    public static final NullPointerException k = null;
    public static final AtomicLong l = null;
    public final Context a;
    public boolean b;
    public Object c;
    public REQUEST d;
    public REQUEST e;
    public ControllerListener<? super INFO> f;
    public boolean g;
    public boolean h;
    public q i;

    public static final enum CacheLevel extends Enum<CacheLevel> {
        public static final CacheLevel BITMAP_MEMORY_CACHE = null;
        public static final CacheLevel DISK_CACHE = null;
        public static final CacheLevel FULL_FETCH = null;
        public static final /* synthetic */ CacheLevel[] a = null;

        static {
            CacheLevel r0 = new CacheLevel("FULL_FETCH", 0);
            FULL_FETCH = r0;
            CacheLevel r1 = new CacheLevel("DISK_CACHE", 1);
            DISK_CACHE = r1;
            CacheLevel r3 = new CacheLevel("BITMAP_MEMORY_CACHE", 2);
            BITMAP_MEMORY_CACHE = r3;
            a = new CacheLevel[]{r0, r1, r3};
        }

        public static CacheLevel[] values() {
            return (CacheLevel[]) a.clone();
        }

        public static CacheLevel valueOf(String r1) {
            return (CacheLevel) r27.a.a(CacheLevel.class, r1);
        }

        public CacheLevel(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class a extends BaseControllerListener<Object> {
        public a() {
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            if (r3 == null) goto L5;
            r3.start();
            return;
        }
    }

    public abstract DataSource a(q r1, Object r2, Object r3, CacheLevel r4);

    static {
        j = new a();
        k = new NullPointerException("No image request was specified!");
        l = new AtomicLong();
    }

    public Context getContext() {
        return this.a;
    }

    public LynxAbstractDraweeControllerBuilder(Context r2) {
        this.a = r2;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.i = null;
    }
}
