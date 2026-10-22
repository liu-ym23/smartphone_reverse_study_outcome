package com.ss.android.lark.filedetail.impl.folder.manage.drawable.property;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExtraVideoProperty {
    public final Context a;
    public final float b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final float h;
    public final Drawable i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/drawable/property/ExtraVideoProperty$BGColorOrientation;", BuildConfig.FLAVOR, "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BGColorOrientation {
        public static final a Companion = null;
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/drawable/property/ExtraVideoProperty$PlayPosition;", BuildConfig.FLAVOR, "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PlayPosition {
        public static final int BOTTOM_RIGHT = 1;
        public static final int CENTER = 0;
        public static final a Companion = null;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public final Context getContext() {
        return this.a;
    }

    public ExtraVideoProperty(Context r1, float r2, int r3, int r4, float r5, float r6, Drawable r7) {
        this.a = r1;
        this.b = r2;
        this.c = 1;
        this.d = r3;
        this.e = r4;
        this.f = 1;
        this.g = r5;
        this.h = r6;
        this.i = r7;
    }
}
