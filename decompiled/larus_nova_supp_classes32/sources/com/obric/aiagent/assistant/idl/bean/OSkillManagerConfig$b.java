package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OSkillManagerConfig$b implements Parcelable.Creator<OSkillManagerConfig> {
    public OSkillManagerConfig$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final OSkillManagerConfig createFromParcel(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        return new OSkillManagerConfig(r3.readBundle(OSkillManagerConfig.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final OSkillManagerConfig[] newArray(int r1) {
        return new OSkillManagerConfig[r1];
    }
}
