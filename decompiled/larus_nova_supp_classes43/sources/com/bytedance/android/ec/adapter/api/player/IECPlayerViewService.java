package com.bytedance.android.ec.adapter.api.player;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d;
import kotlin.Metadata;
import le.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IECPlayerViewService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/player/IECPlayerViewService$RenderViewType;", "", "TEXTURE_VIEW", "SURFACE_VIEW", "KEEP_TEXTURE_RENDER_VIEW", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RenderViewType extends Enum<RenderViewType> {
        public static final RenderViewType KEEP_TEXTURE_RENDER_VIEW = null;
        public static final RenderViewType SURFACE_VIEW = null;
        public static final RenderViewType TEXTURE_VIEW = null;
        public static final /* synthetic */ RenderViewType[] a = null;

        static {
            RenderViewType r1 = new RenderViewType("TEXTURE_VIEW", 0);
            TEXTURE_VIEW = r1;
            RenderViewType r10 = new RenderViewType("SURFACE_VIEW", 1);
            SURFACE_VIEW = r10;
            RenderViewType r11 = new RenderViewType("KEEP_TEXTURE_RENDER_VIEW", 2);
            KEEP_TEXTURE_RENDER_VIEW = r11;
            a = new RenderViewType[]{r1, r10, r11};
        }

        public static RenderViewType valueOf(String r1) {
            return (RenderViewType) r27.a.a(RenderViewType.class, r1);
        }

        public static RenderViewType[] values() {
            return (RenderViewType[]) a.clone();
        }

        public RenderViewType(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
        public static /* synthetic */ b a(IECPlayerViewService r10, Context r11, AttributeSet r12, int r13, String r14, String r15, boolean r16, boolean r17, int r18) {
            if ((r18 & 2) == 0) goto L5;
            AttributeSet r19 = null;
        L7:
            if ((r18 & 4) == 0) goto L9;
            int r20 = 0;
        L11:
            if ((r18 & 16) == 0) goto L13;
            String r21 = "";
        L15:
            return r10.a(r11, r19, r20, r14, r21, null, null);
        L13:
            r21 = r15;
            goto L15
        L9:
            r20 = r13;
            goto L11
        L5:
            r19 = r12;
            goto L7
        }
    }

    d a(Context r1, AttributeSet r10, int r11, String r12, String r13, RenderViewType r14, Long r15);
}
