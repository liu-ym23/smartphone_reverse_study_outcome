package pz1;

import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends AbsPanel<b1> {
    public final k i;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String a() {
        return ((b1) this.h).getText();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final long c() {
        return ((b1) this.h).getId();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String f() {
        return ((b1) this.h).getTitle();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k d() {
        return this.i;
    }

    public c(b1 r2) {
        super(3, r2);
        this.i = r2.getImage();
    }
}
