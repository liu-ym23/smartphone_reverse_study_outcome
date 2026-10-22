package com.bytedance.android.livesdk.interactivity.api.comment.data;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/data/IntercomSyncDataModel;", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel;", "Ldc2/c;", "Lcom/bytedance/android/livesdk/interactivity/api/comment/data/IntercomChangeSyncData;", "intercomStatus$delegate", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel$a;", "getIntercomStatus", "()Ldc2/c;", "intercomStatus", BuildConfig.FLAVOR, "hasUserCloseIntercomCommentTips", "Z", "getHasUserCloseIntercomCommentTips", "()Z", "setHasUserCloseIntercomCommentTips", "(Z)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntercomSyncDataModel extends RoomDataSyncModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private boolean hasUserCloseIntercomCommentTips;
    private final RoomDataSyncModel.a intercomStatus$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(IntercomSyncDataModel.class, "intercomStatus", "getIntercomStatus()Lcom/bytedance/android/livesdk/interactivity/service/wrds/WRDSSettingItem;", 0))};
    }

    public final dc2.c<IntercomChangeSyncData> getIntercomStatus() {
        return (dc2.c) this.intercomStatus$delegate.a(this, $$delegatedProperties[0]);
    }

    public IntercomSyncDataModel() {
        this.intercomStatus$delegate = new RoomDataSyncModel.a(RoomDataSyncModel.access$createSettingItem(this, IntercomChangeSyncData.class, "IntercomChangeSyncData"));
    }

    public final boolean getHasUserCloseIntercomCommentTips() {
        return this.hasUserCloseIntercomCommentTips;
    }

    public final void setHasUserCloseIntercomCommentTips(boolean r1) {
        this.hasUserCloseIntercomCommentTips = r1;
    }
}
