package com.ss.android.lark.framework.assembly.emoji_office;

import androidx.fragment.app.Fragment;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard_biz_emoji_office.dependency.IKeyboardEmojiOfficeDependency;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(IKeyboardEmojiOfficeDependency.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/framework/assembly/emoji_office/KeyboardEmojiOfficeDependencyImpl;", "Lcom/ss/android/lark/keyboard_biz_emoji_office/dependency/IKeyboardEmojiOfficeDependency;", "<init>", "()V", "newCustomStickerFragment", "Landroidx/fragment/app/Fragment;", "emoji-office-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class KeyboardEmojiOfficeDependencyImpl implements IKeyboardEmojiOfficeDependency {
    public KeyboardEmojiOfficeDependencyImpl() {
    }

    @Override // com.ss.android.lark.keyboard_biz_emoji_office.dependency.IKeyboardEmojiOfficeDependency
    public Fragment newCustomStickerFragment() {
        return new OfficeCustomStickerFragment();
    }
}
