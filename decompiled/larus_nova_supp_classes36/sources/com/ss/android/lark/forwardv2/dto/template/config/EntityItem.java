package com.ss.android.lark.forwardv2.dto.template.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.maintab.export.TabAppInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class EntityItem implements Parcelable {
    public static final Parcelable.Creator<EntityItem> CREATOR = null;
    public UserConfig a;
    public GroupChatConfig b;
    public BotConfig c;
    public ThreadConfig d;
    public AIConfig e;

    public class a implements Parcelable.Creator<EntityItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityItem createFromParcel(Parcel r2) {
            return new EntityItem(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final EntityItem[] newArray(int r1) {
            return new EntityItem[r1];
        }
    }

    public static class b {
        public UserConfig a;
        public GroupChatConfig b;
        public BotConfig c;
        public ThreadConfig d;
        public AIConfig e;

        public b() {
        }

        public final EntityItem a() {
            EntityItem r0 = new EntityItem();
            BotConfig r1 = this.c;
            if (r1 == null) goto L5;
            r0.c = r1;
            r0.b = null;
            r0.a = null;
            r0.d = null;
            r0.e = null;
        L5:
            GroupChatConfig r2 = this.b;
            if (r2 == null) goto L8;
            r0.b = r2;
            r0.a = null;
            r0.d = null;
            r0.c = null;
            r0.e = null;
        L8:
            ThreadConfig r3 = this.d;
            if (r3 == null) goto L11;
            r0.d = r3;
            r0.b = null;
            r0.a = null;
            r0.c = null;
            r0.e = null;
        L11:
            UserConfig r4 = this.a;
            if (r4 == null) goto L15;
            r0.a = r4;
            r0.b = null;
            r0.d = null;
            r0.c = null;
            r0.e = null;
        L15:
            if (this.e == null) goto L19;
            int r5 = hib.a.a;
            Intrinsics.checkNotNullParameter("lark.my_ai.main_switch", TabAppInfo.IMAGE_JSON_KEY);
            if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("lark.my_ai.main_switch") == false) goto L19;
            r0.e = this.e;
            r0.a = null;
            r0.b = null;
            r0.d = null;
            r0.c = null;
        L19:
            return r0;
        }

        public final void b(GroupChatConfig r1) {
            this.b = r1;
            this.c = null;
            this.a = null;
            this.d = null;
            this.e = null;
        }

        public final void c(ThreadConfig r1) {
            this.d = r1;
            this.c = null;
            this.b = null;
            this.a = null;
            this.e = null;
        }

        public final void d(UserConfig r1) {
            this.a = r1;
            this.c = null;
            this.b = null;
            this.d = null;
            this.e = null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public EntityItem() {
    }

    public EntityItem(Parcel r2) {
        this.a = (UserConfig) r2.readSerializable();
        this.b = (GroupChatConfig) r2.readSerializable();
        this.d = (ThreadConfig) r2.readSerializable();
        this.c = (BotConfig) r2.readSerializable();
        this.e = (AIConfig) r2.readSerializable();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeSerializable(this.a);
        r1.writeSerializable(this.b);
        r1.writeSerializable(this.d);
        r1.writeSerializable(this.c);
        r1.writeSerializable(this.e);
    }
}
