package com.ss.android.lark.contact.impl.group;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.Lists;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.contact.export.model.PickType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import h18.d;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w3c.g;
import w3c.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004GHIJB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\"H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003H\u0002J\u0018\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003H\u0002J\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0007J\u0014\u0010/\u001a\u00020$2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\n01J\u0014\u00102\u001a\u00020$2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\n01J&\u00104\u001a\u00020$2\u0006\u0010.\u001a\u00020\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020\n012\b\u00105\u001a\u0004\u0018\u00010\u000fJ\u000e\u00106\u001a\u00020$2\u0006\u0010\f\u001a\u00020\rJ\u0016\u00107\u001a\u00020$2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013J\u0018\u00108\u001a\u00020$2\u0006\u0010,\u001a\u00020)2\u0006\u00109\u001a\u00020\u0003H\u0002J\u0018\u0010:\u001a\u00020$2\u0006\u0010,\u001a\u00020)2\u0006\u00109\u001a\u00020\u0003H\u0002J\u0018\u0010;\u001a\u00020$2\u0006\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003H\u0002J.\u0010<\u001a\u00020\u00112\u0006\u0010,\u001a\u00020)2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010*\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010?\u001a\u00020$2\u0006\u0010,\u001a\u00020)2\u0006\u00109\u001a\u00020\u0003H\u0002J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0003H\u0002J\u0018\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020C2\u0006\u00109\u001a\u00020\u0003H\u0002J\u0018\u0010D\u001a\u00020$2\u0006\u0010,\u001a\u00020)2\u0006\u0010E\u001a\u00020\u0011H\u0002J\u0018\u0010F\u001a\u00020$2\u0006\u0010,\u001a\u00020)2\u0006\u00109\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006K"}, d2 = {"Lcom/ss/android/lark/contact/impl/group/ContactsMyGroupAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/contact/impl/group/ContactsMyGroupAdapter$GroupItemViewHolder;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "<init>", "()V", "picType", "Lcom/ss/android/lark/contact/export/model/PickType;", "selectedChatIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "selfContainedChatId", "onItemClickListener", "Lcom/ss/android/lark/contact/impl/group/ContactsMyGroupAdapter$OnItemClickListener;", "onItemSelectedListener", "Lcom/ss/android/lark/contact/impl/group/ContactsMyGroupAdapter$OnItemSelectListener;", "selectedMode", BuildConfig.FLAVOR, "itemCustomizer", "Lcom/ss/android/lark/contact/export/IItemCustomizer;", "isEnableChatPreview", "()Z", "setEnableChatPreview", "(Z)V", "extras", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "setExtras", "(Landroid/os/Bundle;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", BuildConfig.FLAVOR, "onBindViewHolder", BuildConfig.FLAVOR, "holder", "position", "bindChatPreview", "itemView", "Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "chat", "bindSelf", "avatarItemView", "setPickType", "pickType", "setSelectChatIds", "selectedIds", BuildConfig.FLAVOR, "setContainedChatId", "chaIds", "switchToSelectMode", "onItemSelectListener", "setOnItemClickListener", "setItemCustomizer", "bindTitle", Keys.API_RETURN_KEY_DATA, "bindAvatar", "bindCheckBox", "customIntercept", "checkBoxModel", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "bindClick", "enablePickGroup", "interceptClick", "context", "Landroid/content/Context;", "updateCheckBox", "checked", "bindTags", "OnItemClickListener", "OnItemSelectListener", "Companion", "GroupItemViewHolder", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactsMyGroupAdapter extends LarkRecyclerViewBaseAdapter<GroupItemViewHolder, Chat> {
    public PickType a;
    public final Set<String> b;
    public final Set<String> c;
    public b d;
    public boolean e;
    public Bundle f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/contact/impl/group/ContactsMyGroupAdapter$GroupItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "<init>", "(Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;)V", "getV", "()Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GroupItemViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final AvatarItemView a;

        public static final class a {
        }

        static {
        }

        public GroupItemViewHolder(AvatarItemView r1) {
            super(r1);
            this.a = r1;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Chat r1, int r2);
    }

    static {
    }

    public ContactsMyGroupAdapter() {
        this.a = new PickType();
        this.b = new LinkedHashSet();
        this.c = new LinkedHashSet();
    }

    public static final /* synthetic */ List y2(ContactsMyGroupAdapter r0) {
        return ((LarkRecyclerViewBaseAdapter) r0).items;
    }

    public final boolean z2(Chat r7) {
        if (this.a.getEnableExternalGroup() == false) goto L5;
    L10:
        boolean r0 = true;
    L12:
        if (this.a.getEnableSecretGroup() == false) goto L14;
    L19:
        boolean r3 = true;
    L21:
        if (this.a.getEnableMeetingGroup() == false) goto L23;
    L28:
        boolean r4 = true;
    L30:
        if (this.a.getEnablePublicGroup() == false) goto L32;
    L37:
        boolean r8 = true;
    L38:
        if (r0 == false) goto L43;
        if (r3 == false) goto L43;
        if (r4 == false) goto L43;
        if (r8 == false) goto L43;
        return true;
    L43:
        return false;
    L32:
        if (r7.isPublic() == false) goto L34;
    L36:
        r8 = false;
        goto L38
    L34:
        if (this.a.getEnableGroupChat() == false) goto L36;
    L23:
        if (r7.isMeeting() == false) goto L25;
    L27:
        r4 = false;
        goto L30
    L25:
        if (this.a.getEnableGroupChat() == false) goto L27;
    L14:
        if (r7.isSecret() == false) goto L16;
    L18:
        r3 = false;
        goto L21
    L16:
        if (this.a.getEnableGroupChat() == false) goto L18;
    L5:
        if (r7.isCrossTenant() == false) goto L7;
    L9:
        r0 = false;
        goto L12
    L7:
        if (this.a.getEnableGroupChat() == false) goto L9;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        GroupItemViewHolder r11 = (GroupItemViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Chat r12 = (Chat) CollectionsKt.getOrNull(((LarkRecyclerViewBaseAdapter) this).items, r10);
        if (r12 == null) goto L27;
        AvatarItemView r13 = r11.a;
        uz7.a.a r0 = new uz7.a.a();
        r0.k = r12.getId();
        r0.b(r12.getAvatarKey());
        r0.f(r12.getId());
        r13.avatar(new uz7.a(r0));
        if (r12.isUserCountVisible() == false) goto L8;
        String r1 = " (" + r12.getUserCount() + ')';
    L9:
        r13.title(new g(r12.getName(), true, 12));
        r13.titleTail(new h(r1, 0, 6));
        r13.setOnClickListener(new q9b.c(this, r12, r13));
        Context r2 = r13.getContext();
        int r3 = LarkNameTag.d;
        Intrinsics.checkNotNull(r2);
        LarkNameTag.d r4 = LarkNameTag.f.a(r2);
        r4.t = r12.is_department();
        r4.v = r12.isTenant();
        r4.w = r12.isPublic();
        r4.q = r12.isSecret();
        if (Lists.isEmpty(r12.getTags()) == false) goto L12;
        boolean r5 = false;
    L13:
        r4.y = r5;
        if (r12.getTagData() == null) goto L16;
        TagData.a r6 = TagData.Companion;
        TagData r7 = r12.getTagData();
        r6.getClass();
        r4.g(TagData.a.b(r7));
    L16:
        r4.z = false;
        ((LarkNameTag.c) r4).f = r12.isCrossWithKa();
        r13.setTag(r4);
        ImageView r8 = (ImageView) r13.findViewById(2131365578);
        if (this.e == true) goto L19;
    L23:
        if (r8 == null) goto L25;
        r8.setVisibility(8);
    L25:
        z2(r12);
        r13.setAlpha(1.0f);
        return;
    L19:
        if (r12.isSecret() == true) goto L23;
        if (r8 != null) goto L22;
        ImageView r14 = new ImageView(r13.getContext());
        r14.setImageDrawable(UDIconUtils.getIconDrawable(r14.getContext(), 2131254921, UIUtils.getColor(r14.getContext(), 2131102420)));
        r14.setLayoutParams(new ViewGroup.LayoutParams((int) d.b(r14.getContext(), 20), (int) d.b(r14.getContext(), 20)));
        r14.setId(2131365578);
        r8 = r14;
        AvatarItemView.attachRightView$default(r13, r8, false, false, 6, null);
    L22:
        r8.setOnClickListener(new q9b.b(r13, r12, this));
        r8.setVisibility(0);
        goto L25
    L12:
        r5 = r12.getTags().contains(Tag.OFFICIAL);
        goto L13
    L8:
        r1 = BuildConfig.FLAVOR;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        int r0 = GroupItemViewHolder.b;
        Intrinsics.checkNotNullParameter(r9, "parent");
        AvatarItemView r11 = new AvatarItemView(r9.getContext(), null, 0, null, 14, null).applyStyle(2131951705);
        r11.showDivider(false);
        return new GroupItemViewHolder(r11);
    }
}
