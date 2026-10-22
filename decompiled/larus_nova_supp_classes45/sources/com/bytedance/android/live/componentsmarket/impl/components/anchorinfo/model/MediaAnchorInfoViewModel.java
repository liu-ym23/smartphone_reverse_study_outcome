package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.model;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00016B\t\b\u0016¢\u0006\u0004\b2\u00103B\u0013\b\u0016\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b2\u00104J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0017\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aRB\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070$j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007`%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010.R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010.R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.¨\u00067"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/anchorinfo/model/MediaAnchorInfoViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "", "Lpy/k;", "image", "", "avatarImageModle", "", "name", "anchorName", "verifyInfo", "", "hasFansClub", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "_avatarImageModle", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "_anchorName", "_verifyInfo", "_hasFansClub", "isFollowing", "Z", "()Z", "setFollowing", "(Z)V", "", "followStatus", "J", "getFollowStatus", "()J", "setFollowStatus", "(J)V", "isInvalidFollowStatus", "setInvalidFollowStatus", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "followExtraPramsMap", "Ljava/util/HashMap;", "getFollowExtraPramsMap", "()Ljava/util/HashMap;", "setFollowExtraPramsMap", "(Ljava/util/HashMap;)V", "Landroidx/lifecycle/LiveData;", "getAvatarImageModle", "()Landroidx/lifecycle/LiveData;", "getAnchorName", "getVerifyInfo", "getHasFansClub", "<init>", "()V", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaAnchorInfoViewModel extends DataContext {
    public static final a Companion = null;
    public static final String TAG = "AnchorInfoViewModel";
    private final NextLiveData<String> _anchorName;
    private final NextLiveData<k> _avatarImageModle;
    private final NextLiveData<Boolean> _hasFansClub;
    private final NextLiveData<k> _verifyInfo;
    private DataCenter dataCenter;
    private HashMap<String, String> followExtraPramsMap;
    private long followStatus;
    private boolean isFollowing;
    private boolean isInvalidFollowStatus;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MediaAnchorInfoViewModel() {
        this._avatarImageModle = new NextLiveData();
        this._anchorName = new NextLiveData();
        this._verifyInfo = new NextLiveData();
        this._hasFansClub = new NextLiveData();
        this.followExtraPramsMap = new HashMap();
        StringBuilder r0 = new StringBuilder();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        r0.append(String.valueOf(r2));
        r0.append(TAG);
        b.a(this, r0.toString());
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public LiveData<String> getAnchorName() {
        return this._anchorName;
    }

    public LiveData<k> getAvatarImageModle() {
        return this._avatarImageModle;
    }

    public final HashMap<String, String> getFollowExtraPramsMap() {
        return this.followExtraPramsMap;
    }

    public final long getFollowStatus() {
        return this.followStatus;
    }

    public LiveData<Boolean> getHasFansClub() {
        return this._hasFansClub;
    }

    public LiveData<k> getVerifyInfo() {
        return this._verifyInfo;
    }

    public final boolean isFollowing() {
        return this.isFollowing;
    }

    public final boolean isInvalidFollowStatus() {
        return this.isInvalidFollowStatus;
    }

    public MediaAnchorInfoViewModel(DataCenter r2) {
        this._avatarImageModle = new NextLiveData();
        this._anchorName = new NextLiveData();
        this._verifyInfo = new NextLiveData();
        this._hasFansClub = new NextLiveData();
        this.followExtraPramsMap = new HashMap();
        this.dataCenter = r2;
        b.a(this, TAG);
    }

    @JvmStatic
    public static final MediaAnchorInfoViewModel initViewModel(FragmentActivity r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "fragment");
        return ViewModelProviders.of(r1).get(MediaAnchorInfoViewModel.class);
    }

    public void anchorName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this._anchorName.setValue(r2);
    }

    public void avatarImageModle(k r2) {
        this._avatarImageModle.setValue(r2);
    }

    public void hasFansClub(boolean r2) {
        this._hasFansClub.setValue(Boolean.valueOf(r2));
    }

    public final void setFollowExtraPramsMap(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.followExtraPramsMap = r2;
    }

    public final void setFollowStatus(long r1) {
        this.followStatus = r1;
    }

    public final void setFollowing(boolean r1) {
        this.isFollowing = r1;
    }

    public final void setInvalidFollowStatus(boolean r1) {
        this.isInvalidFollowStatus = r1;
    }

    public void verifyInfo(k r2) {
        this._verifyInfo.setValue(r2);
    }
}
