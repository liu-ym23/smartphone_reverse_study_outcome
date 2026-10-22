package com.ss.android.lark.location.dto;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s5c.a;
import s5c.d;
import z5c.m3;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/location/dto/Scene;", "Ljava/io/Serializable;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toStatisticsParam", "Lcom/ss/android/lark/statistics/extensions/IParam;", "IM", "Calendar", "Base", "Minutes", "Meego", "Passport", "OpenPlatform", "Lcom/ss/android/lark/location/dto/Scene$Base;", "Lcom/ss/android/lark/location/dto/Scene$Calendar;", "Lcom/ss/android/lark/location/dto/Scene$IM;", "Lcom/ss/android/lark/location/dto/Scene$Meego;", "Lcom/ss/android/lark/location/dto/Scene$Minutes;", "Lcom/ss/android/lark/location/dto/Scene$OpenPlatform;", "Lcom/ss/android/lark/location/dto/Scene$Passport;", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class Scene implements Serializable {
    private final String name;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/location/dto/Scene$Base;", "Lcom/ss/android/lark/location/dto/Scene;", "<init>", "()V", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Base extends Scene {
        public static final Base INSTANCE = null;

        static {
            INSTANCE = new Base();
        }

        private Base() {
            super("base", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/location/dto/Scene$Calendar;", "Lcom/ss/android/lark/location/dto/Scene;", "<init>", "()V", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Calendar extends Scene {
        public static final Calendar INSTANCE = null;

        static {
            INSTANCE = new Calendar();
        }

        private Calendar() {
            super(IOfflineExtraParser.ParserType.CALENDAR, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/location/dto/Scene$IM;", "Lcom/ss/android/lark/location/dto/Scene;", "<init>", "()V", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class IM extends Scene {
        public static final IM INSTANCE = null;

        static {
            INSTANCE = new IM();
        }

        private IM() {
            super("im", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/location/dto/Scene$Meego;", "Lcom/ss/android/lark/location/dto/Scene;", "<init>", "()V", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Meego extends Scene {
        public static final Meego INSTANCE = null;

        static {
            INSTANCE = new Meego();
        }

        private Meego() {
            super("meego", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/location/dto/Scene$Minutes;", "Lcom/ss/android/lark/location/dto/Scene;", "<init>", "()V", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Minutes extends Scene {
        public static final Minutes INSTANCE = null;

        static {
            INSTANCE = new Minutes();
        }

        private Minutes() {
            super("minutes", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/location/dto/Scene$OpenPlatform;", "Lcom/ss/android/lark/location/dto/Scene;", "subScene", "", "<init>", "(Ljava/lang/String;)V", "getSubScene", "()Ljava/lang/String;", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OpenPlatform extends Scene {
        private final String subScene;

        public final String getSubScene() {
            return this.subScene;
        }

        public OpenPlatform(String r3) {
            Intrinsics.checkNotNullParameter(r3, "subScene");
            super("open_platform", null);
            this.subScene = r3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/location/dto/Scene$Passport;", "Lcom/ss/android/lark/location/dto/Scene;", "<init>", "()V", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Passport extends Scene {
        public static final Passport INSTANCE = null;

        static {
            INSTANCE = new Passport();
        }

        private Passport() {
            super("passport", null);
        }
    }

    public final d toStatisticsParam() {
        a r0 = z2.k.a(this.name);
        if ((this instanceof OpenPlatform) == true) goto L5;
        return r0;
    L5:
        return d.b.b(r0, m3.c.a(((OpenPlatform) this).getSubScene()));
    }

    public final String getName() {
        return this.name;
    }

    public Scene(String r1, DefaultConstructorMarker r2) {
        this.name = r1;
    }
}
