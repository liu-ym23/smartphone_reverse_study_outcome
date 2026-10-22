package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ListTag extends FlexModelBase<v> implements v {
    public static final int TAG_ECOM_FANS_CLUB = 5;
    public static final int TAG_ECOM_VIEW = 4;
    public static final int TAG_FANS = 3;
    public static final int TAG_FANS_CLUB = 0;
    public static final int TAG_FRIEND = 2;
    public static final int TAG_HONOR_LEVEL = 1;

    @SerializedName("ecom_fans_club_tag")
    public ListTagEcomFansClubContent ecomFansClubTag;

    @SerializedName("ecom_view_tag")
    public ListTagEcomViewContent ecomViewTag;

    @SerializedName("fans_club_tag")
    public ListTagFansClubContent listTagFansClubContent;

    @SerializedName("fans_tag")
    public ListTagFansContent listTagFansContent;

    @SerializedName("friend_tag")
    public ListTagFriendContent listTagFriendContent;

    @SerializedName("honor_level_tag")
    public ListTagHonorLevelContent listTagHonorLevelContent;

    @SerializedName("list_tag_type")
    public int type;

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class ListTagEcomFansClubContent extends FlexModelBase<w> implements w {

        @SerializedName("club_name")
        public String clubName;

        @SerializedName("ecom_fans_club_tag")
        public py.k ecomFansClubTag;

        public ListTagEcomFansClubContent() {
            super(w.class);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.model.w
        public String getClubName() {
            return this.clubName;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.model.w
        public py.k getEcomFansClubTag() {
            return this.ecomFansClubTag;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class ListTagEcomViewContent extends FlexModelBase<x> implements x {

        @SerializedName("ecom_view_tag")
        public py.k ecomViewTag;

        public ListTagEcomViewContent() {
            super(x.class);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.model.x
        public py.k getEcomViewTag() {
            return this.ecomViewTag;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class ListTagFansClubContent extends FlexModelBase<y> implements y {

        @SerializedName("club_name")
        public String clubName;

        @SerializedName("icons")
        public Map<Integer, py.k> icons;

        public ListTagFansClubContent() {
            super(y.class);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.model.y
        public String getClubName() {
            return this.clubName;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.model.y
        public Map<Integer, py.k> getIcons() {
            return this.icons;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class ListTagFansContent extends FlexModelBase<z> implements z {

        @SerializedName("fans_tag")
        public py.k fansTag;

        public ListTagFansContent() {
            super(z.class);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.model.z
        public py.k getFansTag() {
            return this.fansTag;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class ListTagFriendContent extends FlexModelBase<a0> implements a0 {

        @SerializedName("friend_tag")
        public py.k friendTag;

        public ListTagFriendContent() {
            super(a0.class);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.model.a0
        public py.k getFriendTag() {
            return this.friendTag;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class ListTagHonorLevelContent extends FlexModelBase<b0> implements b0 {

        @SerializedName("new_im_icon_with_level")
        public py.k newImIconWithLevel;

        public ListTagHonorLevelContent() {
            super(b0.class);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.model.b0
        public py.k getNewImIconWithLevel() {
            return this.newImIconWithLevel;
        }
    }

    public ListTag() {
        super(v.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.v
    public w getEcomFansClubTag() {
        return this.ecomFansClubTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.v
    public x getEcomViewTag() {
        return this.ecomViewTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.v
    public y getListTagFansClubContent() {
        return this.listTagFansClubContent;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.v
    public z getListTagFansContent() {
        return this.listTagFansContent;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.v
    public a0 getListTagFriendContent() {
        return this.listTagFriendContent;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.v
    public b0 getListTagHonorLevelContent() {
        return this.listTagHonorLevelContent;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.v
    public int getType() {
        return this.type;
    }
}
