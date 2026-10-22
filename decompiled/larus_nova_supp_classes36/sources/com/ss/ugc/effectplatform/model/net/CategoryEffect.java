package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CategoryEffect;", "", "category_key", "", "version", "effects", "Lcom/ss/ugc/effectplatform/model/Effect;", "effect_with_video_url", "Lcom/ss/ugc/effectplatform/model/net/EffectWithVideoURL;", "effect_with_video_url_list", "", "collection", "bind_effects", "video_info", "Lcom/ss/ugc/effectplatform/model/net/VideoInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/net/EffectWithVideoURL;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/net/VideoInfo;)V", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class CategoryEffect {
    public List<? extends Effect> bind_effects;
    public String category_key;
    public List<? extends Effect> collection;
    public EffectWithVideoURL effect_with_video_url;
    public List<EffectWithVideoURL> effect_with_video_url_list;
    public Effect effects;
    public String version;
    public VideoInfo video_info;

    public CategoryEffect() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public CategoryEffect(String r1, String r2, Effect r3, EffectWithVideoURL r4, List<EffectWithVideoURL> r5, List<? extends Effect> r6, List<? extends Effect> r7, VideoInfo r8) {
        this.category_key = r1;
        this.version = r2;
        this.effects = r3;
        this.effect_with_video_url = r4;
        this.effect_with_video_url_list = r5;
        this.collection = r6;
        this.bind_effects = r7;
        this.video_info = r8;
    }

    public /* synthetic */ CategoryEffect(String r10, String r11, Effect r12, EffectWithVideoURL r13, List r14, List r15, List r16, VideoInfo r17, int r18, DefaultConstructorMarker r19) {
        VideoInfo r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Effect r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        EffectWithVideoURL r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
