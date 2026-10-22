package com.larus.bmhome.view.resourcebar;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.bmhome.view.resourcebar.viewholder.AddResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.AudioResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.FileResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.ImgResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.PayloadResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.VideoResourceViewHolder;
import com.larus.chat.common.databinding.LarusAddResourceItemViewBinding;
import com.larus.chat.common.databinding.LarusFileResourceItemViewBinding;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nda.d;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0014\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0014\u0010\"\u001a\u00020\u001c*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004J\"\u0010$\u001a\u00020\u001c2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012J\b\u0010&\u001a\u00020\u001cH\u0007J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0011H\u0007J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0007J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0011J\u0016\u0010-\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010*\u001a\u00020+J\u0015\u00100\u001a\u0004\u0018\u00010\u001a2\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012J\u0010\u00103\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u001aH\u0016J\u0010\u00105\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J4\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012H\u0002J8\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002J\u0014\u0010@\u001a\u00020+*\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\f\u0010A\u001a\u00020+*\u00020\u0011H\u0002J\f\u0010B\u001a\u000209*\u00020CH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006E"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/ResourceBarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;)V", "getConfig", "()Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "setConfig", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;)V", "getCallback", "()Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "list", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Lkotlin/collections/ArrayList;", "innerCallback", "com/larus/bmhome/view/resourcebar/ResourceBarAdapter$innerCallback$1", "Lcom/larus/bmhome/view/resourcebar/ResourceBarAdapter$innerCallback$1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "setSpecs", "updateConfig", "refresh", "items", "refreshCurrentItems", "addItem", "item", "removeItem", "key", "", "refreshItem", "refreshUpLinkProgress", "upLinkProgress", "getItem", "getItemPosition", "(Ljava/lang/String;)Ljava/lang/Integer;", "getList", "getItemViewType", "getItemCount", "getItemId", "", "buildRefreshList", "isSameItem", "", "oldItem", "newItem", "oldItemPosition", "newItemPosition", "oldListSize", "newListSize", "stableId", "displayIdentity", "isMediaType", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceBarAdapter extends RecyclerView.Adapter<BaseResourceViewHolder> {
    public static final /* synthetic */ int e = 0;
    public ResourceBarConfig a;
    public final BaseResourceViewHolder.a b;
    public final ArrayList<ResourceItemBean> c;
    public final lt8.a d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceType.values().length];
            r0[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResourceType.AVATAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResourceType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final int getItemCount() {
        return this.c.size();
    }

    public static String y2(ResourceItemBean r5) {
        int r0 = b.a[r5.getResourceType().ordinal()];
        boolean r1 = false;
        String r2 = null;
        if (r0 != 1) goto L5;
    L158:
        Object r3 = r5.getExt().get("ext_img_show_path");
        if ((r3 instanceof String) == false) goto L161;
        String r4 = (String) r3;
    L162:
        if (r4 != null) goto L164;
    L167:
        boolean r6 = true;
    L169:
        if ((!r6) == true) goto L172;
        r4 = null;
    L172:
        if (r4 != null) goto L254;
        Image r7 = r5.getImage();
        if (r7 == null) goto L176;
        r4 = r7.localResPath;
    L177:
        if (r4 != null) goto L179;
    L182:
        boolean r8 = true;
    L184:
        if ((!r8) == true) goto L187;
        r4 = null;
    L187:
        if (r4 != null) goto L254;
        Image r9 = r5.getImage();
        if (r9 == null) goto L191;
        r4 = r9.key;
    L192:
        if (r4 != null) goto L194;
    L197:
        boolean r10 = true;
    L199:
        if ((!r10) == true) goto L202;
        r4 = null;
    L202:
        if (r4 != null) goto L254;
        Image r11 = r5.getImage();
        if (r11 == null) goto L208;
        ImageObj r12 = r11.previewImage;
        if (r12 == null) goto L208;
        r4 = r12.url;
    L209:
        if (r4 != null) goto L211;
    L214:
        boolean r13 = true;
    L216:
        if ((!r13) == true) goto L219;
        r4 = null;
    L219:
        if (r4 != null) goto L254;
        Image r14 = r5.getImage();
        if (r14 == null) goto L225;
        ImageObj r15 = r14.imageThumb;
        if (r15 == null) goto L225;
        r4 = r15.url;
    L226:
        if (r4 != null) goto L228;
    L231:
        boolean r16 = true;
    L233:
        if ((!r16) == true) goto L236;
        r4 = null;
    L236:
        if (r4 != null) goto L254;
        Image r17 = r5.getImage();
        if (r17 == null) goto L242;
        ImageObj r18 = r17.imageOri;
        if (r18 == null) goto L242;
        String r19 = r18.url;
    L243:
        if (r19 != null) goto L245;
    L246:
        r1 = true;
    L248:
        if ((!r1) == false) goto L250;
        r2 = r19;
    L250:
        if (r2 != null) goto L257;
    L251:
        return "";
    L257:
        return r2;
    L245:
        if (StringsKt.isBlank(r19) == false) goto L248;
    L242:
        r19 = null;
        goto L243
    L228:
        if (StringsKt.isBlank(r4) == true) goto L231;
        r16 = false;
    L225:
        r4 = null;
        goto L226
    L211:
        if (StringsKt.isBlank(r4) == true) goto L214;
        r13 = false;
    L208:
        r4 = null;
        goto L209
    L194:
        if (StringsKt.isBlank(r4) == true) goto L197;
        r10 = false;
        goto L199
    L191:
        r4 = null;
        goto L192
    L179:
        if (StringsKt.isBlank(r4) == true) goto L182;
        r8 = false;
        goto L184
    L176:
        r4 = null;
    L254:
        return r4;
    L164:
        if (StringsKt.isBlank(r4) == true) goto L167;
        r6 = false;
        goto L169
    L161:
        r4 = null;
        goto L162
    L5:
        if (r0 == 2) goto L158;
        if (r0 != 3) goto L255;
        mt8.b r20 = r5.getVideo();
        if (r20 == null) goto L12;
        r4 = r20.e;
    L13:
        if (r4 != null) goto L15;
    L18:
        boolean r21 = true;
    L20:
        if ((!r21) == true) goto L23;
        r4 = null;
    L23:
        if (r4 != null) goto L254;
        mt8.b r22 = r5.getVideo();
        if (r22 == null) goto L29;
        Image r23 = r22.a;
        if (r23 == null) goto L29;
        r4 = r23.localResPath;
    L30:
        if (r4 != null) goto L32;
    L35:
        boolean r24 = true;
    L37:
        if ((!r24) == true) goto L40;
        r4 = null;
    L40:
        if (r4 != null) goto L254;
        mt8.b r25 = r5.getVideo();
        if (r25 == null) goto L44;
        r4 = r25.f;
    L45:
        if (r4 != null) goto L47;
    L50:
        boolean r26 = true;
    L52:
        if ((!r26) == true) goto L55;
        r4 = null;
    L55:
        if (r4 != null) goto L254;
        mt8.b r27 = r5.getVideo();
        if (r27 == null) goto L59;
        r4 = r27.g;
    L60:
        if (r4 != null) goto L62;
    L65:
        boolean r28 = true;
    L67:
        if ((!r28) == true) goto L70;
        r4 = null;
    L70:
        if (r4 != null) goto L254;
        mt8.b r29 = r5.getVideo();
        if (r29 == null) goto L74;
        r4 = r29.i;
    L75:
        if (r4 != null) goto L77;
    L80:
        boolean r30 = true;
    L82:
        if ((!r30) == true) goto L85;
        r4 = null;
    L85:
        if (r4 != null) goto L254;
        mt8.b r31 = r5.getVideo();
        if (r31 == null) goto L91;
        Image r32 = r31.a;
        if (r32 == null) goto L91;
        r4 = r32.key;
    L92:
        if (r4 != null) goto L94;
    L97:
        boolean r33 = true;
    L99:
        if ((!r33) == true) goto L102;
        r4 = null;
    L102:
        if (r4 != null) goto L254;
        mt8.b r34 = r5.getVideo();
        if (r34 == null) goto L110;
        Image r35 = r34.a;
        if (r35 == null) goto L110;
        ImageObj r36 = r35.previewImage;
        if (r36 == null) goto L110;
        r4 = r36.url;
    L111:
        if (r4 != null) goto L113;
    L116:
        boolean r37 = true;
    L118:
        if ((!r37) == true) goto L121;
        r4 = null;
    L121:
        if (r4 != null) goto L254;
        mt8.b r38 = r5.getVideo();
        if (r38 == null) goto L129;
        Image r39 = r38.a;
        if (r39 == null) goto L129;
        ImageObj r40 = r39.imageThumb;
        if (r40 == null) goto L129;
        r4 = r40.url;
    L130:
        if (r4 != null) goto L132;
    L135:
        boolean r41 = true;
    L137:
        if ((!r41) == true) goto L140;
        r4 = null;
    L140:
        if (r4 != null) goto L254;
        mt8.b r42 = r5.getVideo();
        if (r42 == null) goto L148;
        Image r43 = r42.a;
        if (r43 == null) goto L148;
        ImageObj r44 = r43.imageOri;
        if (r44 == null) goto L148;
        String r45 = r44.url;
    L149:
        if (r45 != null) goto L151;
    L152:
        r1 = true;
    L154:
        if ((!r1) == false) goto L156;
        r2 = r45;
    L156:
        if (r2 != null) goto L257;
    L151:
        if (StringsKt.isBlank(r45) == false) goto L154;
    L148:
        r45 = null;
        goto L149
    L132:
        if (StringsKt.isBlank(r4) == true) goto L135;
        r41 = false;
    L129:
        r4 = null;
        goto L130
    L113:
        if (StringsKt.isBlank(r4) == true) goto L116;
        r37 = false;
    L110:
        r4 = null;
        goto L111
    L94:
        if (StringsKt.isBlank(r4) == true) goto L97;
        r33 = false;
    L91:
        r4 = null;
        goto L92
    L77:
        if (StringsKt.isBlank(r4) == true) goto L80;
        r30 = false;
        goto L82
    L74:
        r4 = null;
        goto L75
    L62:
        if (StringsKt.isBlank(r4) == true) goto L65;
        r28 = false;
        goto L67
    L59:
        r4 = null;
        goto L60
    L47:
        if (StringsKt.isBlank(r4) == true) goto L50;
        r26 = false;
        goto L52
    L44:
        r4 = null;
        goto L45
    L32:
        if (StringsKt.isBlank(r4) == true) goto L35;
        r24 = false;
    L29:
        r4 = null;
        goto L30
    L15:
        if (StringsKt.isBlank(r4) == true) goto L18;
        r21 = false;
        goto L20
    L12:
        r4 = null;
        goto L13
    L255:
        return r5.getKey();
    }

    public final long getItemId(int r7) {
        ResourceItemBean r0 = (ResourceItemBean) CollectionsKt.getOrNull(this.c, r7);
        if (r0 == null) goto L31;
        boolean r3 = false;
        if (this.a.getMode() != Mode.SHOW) goto L17;
        ResourceType r1 = r0.getResourceType();
        if (r1 != ResourceType.IMAGE) goto L9;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        StringBuilder r4 = new StringBuilder();
        r4.append(r0.getResourceType().getValue());
        r4.append('_');
        r4.append(r7);
        String r5 = r4.toString();
    L28:
        if (r5 == null) goto L31;
        return r5.hashCode();
    L9:
        if (r1 == ResourceType.AVATAR) goto L14;
        if (r1 == ResourceType.VIDEO) goto L14;
        r2 = false;
    L17:
        String r6 = r0.getKey();
        if ((!StringsKt.isBlank(r6)) == true) goto L21;
        r6 = null;
    L21:
        if (r6 != null) goto L27;
        r6 = y2(r0);
        if (r6.length() != 0) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L27;
        StringBuilder r8 = new StringBuilder();
        r8.append(r0.getResourceType().getValue());
        r8.append('_');
        r8.append(r7);
        r5 = r8.toString();
    L27:
        r5 = r6;
    L31:
        return super.getItemId(r7);
    }

    public final int getItemViewType(int r2) {
        ResourceItemBean r3 = (ResourceItemBean) CollectionsKt.getOrNull(this.c, r2);
        if (r3 == null) goto L7;
        ResourceType r4 = r3.getResourceType();
        if (r4 == null) goto L7;
    L9:
        return r4.getValue();
    L7:
        r4 = ResourceType.FILE;
        goto L9
    }

    public final Integer z2(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Iterator<T> r0 = this.c.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (Intrinsics.areEqual(r5, ((ResourceItemBean) r2).getKey()) == true) goto L11;
        r1 = r3;
        goto L4
    L11:
        return Integer.valueOf(r1);
    L13:
        return null;
    }

    public ResourceBarAdapter(ResourceBarConfig r2, ResourceBar.b r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        setHasStableIds(true);
        this.d = new lt8.a(this);
    }

    public final void A2(BaseResourceViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        ResourceBarConfig r0 = this.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r4.a = r0;
        ViewGroup.LayoutParams r1 = ((RecyclerView.ViewHolder) r4).itemView.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L6:
        if (r2 == null) goto L15;
        int r3 = 0;
        if (r5 != 0) goto L10;
        int r6 = r4.a.getMarginStart();
    L11:
        r2.setMarginStart(r6);
        if (CollectionsKt.getLastIndex(this.c) != r5) goto L14;
        r3 = r4.a.getMarginEnd() - i5.r0();
    L14:
        r2.setMarginEnd(r3);
        goto L15
    L10:
        r6 = 0;
    L15:
        ResourceItemBean r7 = (ResourceItemBean) CollectionsKt.getOrNull(this.c, r5);
        if (r7 == null) goto L19;
        r4.T3(r7, this.d);
        return;
    L19:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void B2(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Integer r4 = z2(r2);
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
        ResourceItemBean r0 = (ResourceItemBean) CollectionsKt.getOrNull(this.c, r5);
        if (r0 == null) goto L7;
        r0.setUpLinkProgress(r3);
    L7:
        notifyItemChanged(r5);
        return;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        A2((BaseResourceViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (r7 != ResourceType.ADD.getValue()) goto L10;
        ResourceBarConfig r1 = this.a;
        ConstraintLayout r8 = LayoutInflater.from(r6.getContext()).inflate(2131561802, r6, false);
        if (r8 == null) goto L8;
        RecyclerView.ViewHolder r0 = new AddResourceViewHolder(r1, new LarusAddResourceItemViewBinding(r8));
    L25:
        d.a().ta(r7, r0.itemView);
        return r0;
    L8:
        throw new NullPointerException("rootView");
    L10:
        if (r7 != ResourceType.IMAGE.getValue()) goto L12;
    L24:
        r0 = new ImgResourceViewHolder(this.a, LarusFileResourceItemViewBinding.a(LayoutInflater.from(r6.getContext()), r6));
        goto L25
    L12:
        if (r7 == ResourceType.AVATAR.getValue()) goto L24;
        if (r7 != ResourceType.AUDIO.getValue()) goto L18;
        r0 = new AudioResourceViewHolder(this.a, LarusFileResourceItemViewBinding.a(LayoutInflater.from(r6.getContext()), r6));
        goto L25
    L18:
        if (r7 != ResourceType.VIDEO.getValue()) goto L20;
        r0 = new VideoResourceViewHolder(this.a, LarusFileResourceItemViewBinding.a(LayoutInflater.from(r6.getContext()), r6));
        goto L25
    L20:
        Function2<ResourceBarConfig, ViewGroup, BaseResourceViewHolder> r2 = this.a.getCustomRender().get(Integer.valueOf(r7));
        if (r2 != null) goto L27;
        r0 = new FileResourceViewHolder(this.a, LarusFileResourceItemViewBinding.a(LayoutInflater.from(r6.getContext()), r6));
        goto L25
    L27:
        return (BaseResourceViewHolder) r2.invoke(this.a, r6);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        BaseResourceViewHolder r5 = (BaseResourceViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if ((r5 instanceof PayloadResourceViewHolder) == true) goto L5;
    L9:
        A2(r5, r3);
        return;
    L5:
        if ((!r4.isEmpty()) == false) goto L9;
        if (((ResourceItemBean) CollectionsKt.getOrNull(this.c, r3)) == null) goto L11;
        ((PayloadResourceViewHolder) r5).U3(r4);
        return;
    }
}
