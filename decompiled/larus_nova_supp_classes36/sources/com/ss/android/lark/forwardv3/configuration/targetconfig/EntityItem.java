package com.ss.android.lark.forwardv3.configuration.targetconfig;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/EntityItem;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/UserConfig;", "userConfig", "getUserConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/UserConfig;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/GroupConfig;", "groupConfig", "getGroupConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/GroupConfig;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/BotConfig;", "botConfig", "getBotConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/BotConfig;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/ThreadConfig;", "threadConfig", "getThreadConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/ThreadConfig;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/AIConfig;", "aiConfig", "getAiConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/AIConfig;", "writeToParcel", "", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class EntityItem implements Parcelable {
    public static final b CREATOR = null;
    public UserConfig a;
    public GroupConfig b;
    public BotConfig c;
    public ThreadConfig d;
    public AIConfig e;

    public static final class a {
        public UserConfig a;
        public GroupConfig b;
        public BotConfig c;
        public ThreadConfig d;
        public AIConfig e;

        public a() {
        }

        public final EntityItem c() {
            EntityItem r0 = new EntityItem();
            UserConfig r1 = this.a;
            if (r1 == null) goto L5;
            r0.a = r1;
        L5:
            GroupConfig r2 = this.b;
            if (r2 == null) goto L8;
            r0.b = r2;
        L8:
            BotConfig r3 = this.c;
            if (r3 == null) goto L11;
            r0.c = r3;
        L11:
            ThreadConfig r4 = this.d;
            if (r4 == null) goto L15;
            r0.d = r4;
        L15:
            if (this.e == null) goto L19;
            int r5 = com.ss.android.lark.forwardv3.utils.b.a;
            boolean r6 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("lark.my_ai.main_switch");
            Log.i("FGUtils", "FG key: lark.my_ai.main_switch, is " + r6);
            if (r6 == false) goto L19;
            r0.e = this.e;
        L19:
            return r0;
        }

        public final void a(AIConfig r2) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = r2;
        }

        public final void b(BotConfig r2) {
            this.a = null;
            this.b = null;
            this.c = r2;
            this.d = null;
            this.e = null;
        }

        public final void d(GroupConfig r2) {
            this.a = null;
            this.b = r2;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        public final void e(ThreadConfig r2) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = r2;
            this.e = null;
        }

        public final void f(UserConfig r1) {
            this.a = r1;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    public static final class b implements Parcelable.Creator<EntityItem> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityItem createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Intrinsics.checkNotNullParameter(r3, "parcel");
            EntityItem r1 = new EntityItem();
            r1.a = (UserConfig) r3.readSerializable();
            r1.b = (GroupConfig) r3.readSerializable();
            r1.c = (BotConfig) r3.readSerializable();
            r1.d = (ThreadConfig) r3.readSerializable();
            r1.e = (AIConfig) r3.readSerializable();
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final EntityItem[] newArray(int r1) {
            return new EntityItem[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public EntityItem() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeSerializable(this.a);
        r1.writeSerializable(this.b);
        r1.writeSerializable(this.c);
        r1.writeSerializable(this.d);
        r1.writeSerializable(this.e);
    }
}
