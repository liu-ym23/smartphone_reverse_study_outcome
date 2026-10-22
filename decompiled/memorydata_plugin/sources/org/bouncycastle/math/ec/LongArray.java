package org.bouncycastle.math.ec;

import android.R;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
class LongArray implements Cloneable {
    private static final short[] INTERLEAVE2_TABLE = null;
    private static final int[] INTERLEAVE3_TABLE = null;
    private static final int[] INTERLEAVE4_TABLE = null;
    private static final int[] INTERLEAVE5_TABLE = null;
    private static final long[] INTERLEAVE7_TABLE = null;
    static final byte[] bitLengths = null;
    private long[] m_ints;

    static {
        INTERLEAVE2_TABLE = new short[]{0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
        INTERLEAVE3_TABLE = new int[]{0, 1, 8, 9, 64, 65, 72, 73, 512, InputDeviceCompat.SOURCE_DPAD, 520, 521, 576, 577, 584, 585, 4096, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, 4104, 4105, 4160, 4161, 4168, 4169, 4608, 4609, 4616, 4617, 4672, 4673, 4680, 4681, 32768, 32769, 32776, 32777, 32832, 32833, 32840, 32841, 33280, 33281, 33288, 33289, 33344, 33345, 33352, 33353, 36864, 36865, 36872, 36873, 36928, 36929, 36936, 36937, 37376, 37377, 37384, 37385, 37440, 37441, 37448, 37449, 262144, 262145, 262152, 262153, 262208, 262209, 262216, 262217, 262656, 262657, 262664, 262665, 262720, 262721, 262728, 262729, 266240, 266241, 266248, 266249, 266304, 266305, 266312, 266313, 266752, 266753, 266760, 266761, 266816, 266817, 266824, 266825, 294912, 294913, 294920, 294921, 294976, 294977, 294984, 294985, 295424, 295425, 295432, 295433, 295488, 295489, 295496, 295497, 299008, 299009, 299016, 299017, 299072, 299073, 299080, 299081, 299520, 299521, 299528, 299529, 299584, 299585, 299592, 299593};
        INTERLEAVE4_TABLE = new int[]{0, 1, 16, 17, 256, 257, 272, 273, 4096, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, 4112, 4113, 4352, 4353, 4368, 4369, 65536, 65537, 65552, 65553, 65792, 65793, 65808, 65809, 69632, 69633, 69648, 69649, 69888, 69889, 69904, 69905, 1048576, 1048577, 1048592, 1048593, 1048832, 1048833, 1048848, 1048849, 1052672, 1052673, 1052688, 1052689, 1052928, 1052929, 1052944, 1052945, 1114112, 1114113, 1114128, 1114129, 1114368, 1114369, 1114384, 1114385, 1118208, 1118209, 1118224, 1118225, 1118464, 1118465, 1118480, 1118481, 16777216, 16777217, InputDeviceCompat.SOURCE_JOYSTICK, 16777233, 16777472, 16777473, 16777488, 16777489, 16781312, 16781313, 16781328, 16781329, 16781568, 16781569, 16781584, 16781585, R.attr.theme, R.attr.label, R.attr.exported, R.attr.process, R.attr.transcriptMode, R.attr.cacheColorHint, R.attr.childIndicatorRight, R.attr.childDivider, 16846848, 16846849, 16846864, 16846865, 16847104, 16847105, 16847120, 16847121, R.raw.loaderror, R.raw.nodomain, 17825808, 17825809, 17826048, 17826049, 17826064, 17826065, 17829888, 17829889, 17829904, 17829905, 17830144, 17830145, 17830160, 17830161, R.bool.config_sendPackageName, R.bool.config_showDefaultAssistant, R.bool.allow_test_udfps, R.bool.auto_data_switch_ping_test_before_switch, R.bool.config_cecRoutingControl_userConfigurable, R.bool.config_cecSetMenuLanguageDisabled_allowed, R.bool.config_cecSystemAudioModeMutingDisabled_allowed, R.bool.config_cecSystemAudioModeMutingDisabled_default, 17895424, 17895425, 17895440, 17895441, 17895680, 17895681, 17895696, 17895697, SQLiteDatabase.CREATE_IF_NECESSARY, 268435457, 268435472, 268435473, 268435712, 268435713, 268435728, 268435729, 268439552, 268439553, 268439568, 268439569, 268439808, 268439809, 268439824, 268439825, 268500992, 268500993, 268501008, 268501009, 268501248, 268501249, 268501264, 268501265, 268505088, 268505089, 268505104, 268505105, 268505344, 268505345, 268505360, 268505361, 269484032, 269484033, 269484048, 269484049, 269484288, 269484289, 269484304, 269484305, 269488128, 269488129, 269488144, 269488145, 269488384, 269488385, 269488400, 269488401, 269549568, 269549569, 269549584, 269549585, 269549824, 269549825, 269549840, 269549841, 269553664, 269553665, 269553680, 269553681, 269553920, 269553921, 269553936, 269553937, 285212672, 285212673, 285212688, 285212689, 285212928, 285212929, 285212944, 285212945, 285216768, 285216769, 285216784, 285216785, 285217024, 285217025, 285217040, 285217041, 285278208, 285278209, 285278224, 285278225, 285278464, 285278465, 285278480, 285278481, 285282304, 285282305, 285282320, 285282321, 285282560, 285282561, 285282576, 285282577, 286261248, 286261249, 286261264, 286261265, 286261504, 286261505, 286261520, 286261521, 286265344, 286265345, 286265360, 286265361, 286265600, 286265601, 286265616, 286265617, 286326784, 286326785, 286326800, 286326801, 286327040, 286327041, 286327056, 286327057, 286330880, 286330881, 286330896, 286330897, 286331136, 286331137, 286331152, 286331153};
        INTERLEAVE5_TABLE = new int[]{0, 1, 32, 33, 1024, InputDeviceCompat.SOURCE_GAMEPAD, 1056, 1057, 32768, 32769, 32800, 32801, 33792, 33793, 33824, 33825, 1048576, 1048577, 1048608, 1048609, 1049600, 1049601, 1049632, 1049633, 1081344, 1081345, 1081376, 1081377, 1082368, 1082369, 1082400, 1082401, 33554432, InputDeviceCompat.SOURCE_HDMI, 33554464, 33554465, 33555456, 33555457, 33555488, 33555489, 33587200, 33587201, 33587232, 33587233, 33588224, 33588225, 33588256, 33588257, 34603008, 34603009, 34603040, 34603041, 34604032, 34604033, 34604064, 34604065, 34635776, 34635777, 34635808, 34635809, 34636800, 34636801, 34636832, 34636833, 1073741824, 1073741825, 1073741856, 1073741857, 1073742848, 1073742849, 1073742880, 1073742881, 1073774592, 1073774593, 1073774624, 1073774625, 1073775616, 1073775617, 1073775648, 1073775649, 1074790400, 1074790401, 1074790432, 1074790433, 1074791424, 1074791425, 1074791456, 1074791457, 1074823168, 1074823169, 1074823200, 1074823201, 1074824192, 1074824193, 1074824224, 1074824225, 1107296256, 1107296257, 1107296288, 1107296289, 1107297280, 1107297281, 1107297312, 1107297313, 1107329024, 1107329025, 1107329056, 1107329057, 1107330048, 1107330049, 1107330080, 1107330081, 1108344832, 1108344833, 1108344864, 1108344865, 1108345856, 1108345857, 1108345888, 1108345889, 1108377600, 1108377601, 1108377632, 1108377633, 1108378624, 1108378625, 1108378656, 1108378657};
        INTERLEAVE7_TABLE = new long[]{0, 1, 128, 129, 16384, 16385, 16512, 16513, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 2097153, 2097280, 2097281, 2113536, 2113537, 2113664, 2113665, 268435456, 268435457, 268435584, 268435585, 268451840, 268451841, 268451968, 268451969, 270532608, 270532609, 270532736, 270532737, 270548992, 270548993, 270549120, 270549121, 34359738368L, 34359738369L, 34359738496L, 34359738497L, 34359754752L, 34359754753L, 34359754880L, 34359754881L, 34361835520L, 34361835521L, 34361835648L, 34361835649L, 34361851904L, 34361851905L, 34361852032L, 34361852033L, 34628173824L, 34628173825L, 34628173952L, 34628173953L, 34628190208L, 34628190209L, 34628190336L, 34628190337L, 34630270976L, 34630270977L, 34630271104L, 34630271105L, 34630287360L, 34630287361L, 34630287488L, 34630287489L, 4398046511104L, 4398046511105L, 4398046511232L, 4398046511233L, 4398046527488L, 4398046527489L, 4398046527616L, 4398046527617L, 4398048608256L, 4398048608257L, 4398048608384L, 4398048608385L, 4398048624640L, 4398048624641L, 4398048624768L, 4398048624769L, 4398314946560L, 4398314946561L, 4398314946688L, 4398314946689L, 4398314962944L, 4398314962945L, 4398314963072L, 4398314963073L, 4398317043712L, 4398317043713L, 4398317043840L, 4398317043841L, 4398317060096L, 4398317060097L, 4398317060224L, 4398317060225L, 4432406249472L, 4432406249473L, 4432406249600L, 4432406249601L, 4432406265856L, 4432406265857L, 4432406265984L, 4432406265985L, 4432408346624L, 4432408346625L, 4432408346752L, 4432408346753L, 4432408363008L, 4432408363009L, 4432408363136L, 4432408363137L, 4432674684928L, 4432674684929L, 4432674685056L, 4432674685057L, 4432674701312L, 4432674701313L, 4432674701440L, 4432674701441L, 4432676782080L, 4432676782081L, 4432676782208L, 4432676782209L, 4432676798464L, 4432676798465L, 4432676798592L, 4432676798593L, 562949953421312L, 562949953421313L, 562949953421440L, 562949953421441L, 562949953437696L, 562949953437697L, 562949953437824L, 562949953437825L, 562949955518464L, 562949955518465L, 562949955518592L, 562949955518593L, 562949955534848L, 562949955534849L, 562949955534976L, 562949955534977L, 562950221856768L, 562950221856769L, 562950221856896L, 562950221856897L, 562950221873152L, 562950221873153L, 562950221873280L, 562950221873281L, 562950223953920L, 562950223953921L, 562950223954048L, 562950223954049L, 562950223970304L, 562950223970305L, 562950223970432L, 562950223970433L, 562984313159680L, 562984313159681L, 562984313159808L, 562984313159809L, 562984313176064L, 562984313176065L, 562984313176192L, 562984313176193L, 562984315256832L, 562984315256833L, 562984315256960L, 562984315256961L, 562984315273216L, 562984315273217L, 562984315273344L, 562984315273345L, 562984581595136L, 562984581595137L, 562984581595264L, 562984581595265L, 562984581611520L, 562984581611521L, 562984581611648L, 562984581611649L, 562984583692288L, 562984583692289L, 562984583692416L, 562984583692417L, 562984583708672L, 562984583708673L, 562984583708800L, 562984583708801L, 567347999932416L, 567347999932417L, 567347999932544L, 567347999932545L, 567347999948800L, 567347999948801L, 567347999948928L, 567347999948929L, 567348002029568L, 567348002029569L, 567348002029696L, 567348002029697L, 567348002045952L, 567348002045953L, 567348002046080L, 567348002046081L, 567348268367872L, 567348268367873L, 567348268368000L, 567348268368001L, 567348268384256L, 567348268384257L, 567348268384384L, 567348268384385L, 567348270465024L, 567348270465025L, 567348270465152L, 567348270465153L, 567348270481408L, 567348270481409L, 567348270481536L, 567348270481537L, 567382359670784L, 567382359670785L, 567382359670912L, 567382359670913L, 567382359687168L, 567382359687169L, 567382359687296L, 567382359687297L, 567382361767936L, 567382361767937L, 567382361768064L, 567382361768065L, 567382361784320L, 567382361784321L, 567382361784448L, 567382361784449L, 567382628106240L, 567382628106241L, 567382628106368L, 567382628106369L, 567382628122624L, 567382628122625L, 567382628122752L, 567382628122753L, 567382630203392L, 567382630203393L, 567382630203520L, 567382630203521L, 567382630219776L, 567382630219777L, 567382630219904L, 567382630219905L, 72057594037927936L, 72057594037927937L, 72057594037928064L, 72057594037928065L, 72057594037944320L, 72057594037944321L, 72057594037944448L, 72057594037944449L, 72057594040025088L, 72057594040025089L, 72057594040025216L, 72057594040025217L, 72057594040041472L, 72057594040041473L, 72057594040041600L, 72057594040041601L, 72057594306363392L, 72057594306363393L, 72057594306363520L, 72057594306363521L, 72057594306379776L, 72057594306379777L, 72057594306379904L, 72057594306379905L, 72057594308460544L, 72057594308460545L, 72057594308460672L, 72057594308460673L, 72057594308476928L, 72057594308476929L, 72057594308477056L, 72057594308477057L, 72057628397666304L, 72057628397666305L, 72057628397666432L, 72057628397666433L, 72057628397682688L, 72057628397682689L, 72057628397682816L, 72057628397682817L, 72057628399763456L, 72057628399763457L, 72057628399763584L, 72057628399763585L, 72057628399779840L, 72057628399779841L, 72057628399779968L, 72057628399779969L, 72057628666101760L, 72057628666101761L, 72057628666101888L, 72057628666101889L, 72057628666118144L, 72057628666118145L, 72057628666118272L, 72057628666118273L, 72057628668198912L, 72057628668198913L, 72057628668199040L, 72057628668199041L, 72057628668215296L, 72057628668215297L, 72057628668215424L, 72057628668215425L, 72061992084439040L, 72061992084439041L, 72061992084439168L, 72061992084439169L, 72061992084455424L, 72061992084455425L, 72061992084455552L, 72061992084455553L, 72061992086536192L, 72061992086536193L, 72061992086536320L, 72061992086536321L, 72061992086552576L, 72061992086552577L, 72061992086552704L, 72061992086552705L, 72061992352874496L, 72061992352874497L, 72061992352874624L, 72061992352874625L, 72061992352890880L, 72061992352890881L, 72061992352891008L, 72061992352891009L, 72061992354971648L, 72061992354971649L, 72061992354971776L, 72061992354971777L, 72061992354988032L, 72061992354988033L, 72061992354988160L, 72061992354988161L, 72062026444177408L, 72062026444177409L, 72062026444177536L, 72062026444177537L, 72062026444193792L, 72062026444193793L, 72062026444193920L, 72062026444193921L, 72062026446274560L, 72062026446274561L, 72062026446274688L, 72062026446274689L, 72062026446290944L, 72062026446290945L, 72062026446291072L, 72062026446291073L, 72062026712612864L, 72062026712612865L, 72062026712612992L, 72062026712612993L, 72062026712629248L, 72062026712629249L, 72062026712629376L, 72062026712629377L, 72062026714710016L, 72062026714710017L, 72062026714710144L, 72062026714710145L, 72062026714726400L, 72062026714726401L, 72062026714726528L, 72062026714726529L, 72620543991349248L, 72620543991349249L, 72620543991349376L, 72620543991349377L, 72620543991365632L, 72620543991365633L, 72620543991365760L, 72620543991365761L, 72620543993446400L, 72620543993446401L, 72620543993446528L, 72620543993446529L, 72620543993462784L, 72620543993462785L, 72620543993462912L, 72620543993462913L, 72620544259784704L, 72620544259784705L, 72620544259784832L, 72620544259784833L, 72620544259801088L, 72620544259801089L, 72620544259801216L, 72620544259801217L, 72620544261881856L, 72620544261881857L, 72620544261881984L, 72620544261881985L, 72620544261898240L, 72620544261898241L, 72620544261898368L, 72620544261898369L, 72620578351087616L, 72620578351087617L, 72620578351087744L, 72620578351087745L, 72620578351104000L, 72620578351104001L, 72620578351104128L, 72620578351104129L, 72620578353184768L, 72620578353184769L, 72620578353184896L, 72620578353184897L, 72620578353201152L, 72620578353201153L, 72620578353201280L, 72620578353201281L, 72620578619523072L, 72620578619523073L, 72620578619523200L, 72620578619523201L, 72620578619539456L, 72620578619539457L, 72620578619539584L, 72620578619539585L, 72620578621620224L, 72620578621620225L, 72620578621620352L, 72620578621620353L, 72620578621636608L, 72620578621636609L, 72620578621636736L, 72620578621636737L, 72624942037860352L, 72624942037860353L, 72624942037860480L, 72624942037860481L, 72624942037876736L, 72624942037876737L, 72624942037876864L, 72624942037876865L, 72624942039957504L, 72624942039957505L, 72624942039957632L, 72624942039957633L, 72624942039973888L, 72624942039973889L, 72624942039974016L, 72624942039974017L, 72624942306295808L, 72624942306295809L, 72624942306295936L, 72624942306295937L, 72624942306312192L, 72624942306312193L, 72624942306312320L, 72624942306312321L, 72624942308392960L, 72624942308392961L, 72624942308393088L, 72624942308393089L, 72624942308409344L, 72624942308409345L, 72624942308409472L, 72624942308409473L, 72624976397598720L, 72624976397598721L, 72624976397598848L, 72624976397598849L, 72624976397615104L, 72624976397615105L, 72624976397615232L, 72624976397615233L, 72624976399695872L, 72624976399695873L, 72624976399696000L, 72624976399696001L, 72624976399712256L, 72624976399712257L, 72624976399712384L, 72624976399712385L, 72624976666034176L, 72624976666034177L, 72624976666034304L, 72624976666034305L, 72624976666050560L, 72624976666050561L, 72624976666050688L, 72624976666050689L, 72624976668131328L, 72624976668131329L, 72624976668131456L, 72624976668131457L, 72624976668147712L, 72624976668147713L, 72624976668147840L, 72624976668147841L};
        bitLengths = new byte[]{0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    }

    public LongArray(int r1) {
        this.m_ints = new long[r1];
    }

    public LongArray(BigInteger r13) {
        if (r13 == null) goto L27;
        if (r13.signum() < 0) goto L27;
        if (r13.signum() != 0) goto L10;
        this.m_ints = new long[]{0};
        return;
    L10:
        byte[] r14 = r13.toByteArray();
        int r0 = r14.length;
        if (r14[0] != 0) goto L13;
        r0 = r0 - 1;
        int r5 = 1;
    L14:
        int r6 = (r0 + 7) / 8;
        this.m_ints = new long[r6];
        int r7 = r6 - 1;
        int r1 = (r0 % 8) + r5;
        if (r5 >= r1) goto L20;
        long r8 = 0;
    L17:
        if (r5 >= r1) goto L19;
        r8 = (r8 << 8) | ((long) (r14[r5] & 255));
        r5 = r5 + 1;
        goto L17
    L19:
        this.m_ints[r7] = r8;
        r7 = r7 - 1;
    L20:
        if (r7 < 0) goto L25;
        long r9 = 0;
        int r2 = 0;
    L22:
        if (r2 >= 8) goto L24;
        r9 = (r9 << 8) | ((long) (r14[r5] & 255));
        r2 = r2 + 1;
        r5 = r5 + 1;
        goto L22
    L24:
        this.m_ints[r7] = r9;
        r7 = r7 - 1;
        goto L20
    L25:
        return;
    L13:
        r5 = 0;
    L27:
        throw new IllegalArgumentException("invalid F2m field value");
    }

    public LongArray(long[] r1) {
        this.m_ints = r1;
    }

    public LongArray(long[] r2, int r3, int r4) {
        if (r3 == 0) goto L5;
    L7:
        long[] r0 = new long[r4];
        this.m_ints = r0;
        System.arraycopy(r2, r3, r0, 0, r4);
        return;
    L5:
        if (r4 != r2.length) goto L7;
        this.m_ints = r2;
    }

    private static void add(long[] r6, int r7, long[] r8, int r9, int r10) {
        int r0 = 0;
    L3:
        if (r0 >= r10) goto L5;
        int r1 = r7 + r0;
        r6[r1] = r6[r1] ^ r8[r9 + r0];
        r0 = r0 + 1;
        goto L3
    }

    private static void add(long[] r6, int r7, long[] r8, int r9, long[] r10, int r11, int r12) {
        int r0 = 0;
    L3:
        if (r0 >= r12) goto L5;
        r10[r11 + r0] = r6[r7 + r0] ^ r8[r9 + r0];
        r0 = r0 + 1;
        goto L3
    }

    private static void addBoth(long[] r8, int r9, long[] r10, int r11, long[] r12, int r13, int r14) {
        int r0 = 0;
    L3:
        if (r0 >= r14) goto L5;
        int r1 = r9 + r0;
        r8[r1] = r8[r1] ^ (r10[r11 + r0] ^ r12[r13 + r0]);
        r0 = r0 + 1;
        goto L3
    }

    private void addShiftedByBitsSafe(LongArray r8, int r9, int r10) {
        int r11 = (r9 + 63) >>> 6;
        int r6 = r10 >>> 6;
        int r5 = r10 & 63;
        if (r5 != 0) goto L6;
        add(this.m_ints, r6, r8.m_ints, 0, r11);
        return;
    L6:
        long r0 = addShiftedUp(this.m_ints, r6, r8.m_ints, 0, r11, r5);
        if (r0 == 0) goto L10;
        long[] r7 = this.m_ints;
        int r12 = r11 + r6;
        r7[r12] = r0 ^ r7[r12];
        return;
    }

    private static long addShiftedDown(long[] r10, int r11, long[] r12, int r13, int r14, int r15) {
        int r0 = 64 - r15;
        long r1 = 0;
    L3:
        r14 = r14 - 1;
        if (r14 < 0) goto L6;
        long r3 = r12[r13 + r14];
        int r5 = r11 + r14;
        r10[r5] = (r1 | (r3 >>> r15)) ^ r10[r5];
        r1 = r3 << r0;
        goto L3
    L6:
        return r1;
    }

    private static long addShiftedUp(long[] r12, int r13, long[] r14, int r15, int r16, int r17) {
        int r0 = 64 - r17;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r16) goto L5;
        long r5 = r14[r15 + r3];
        int r7 = r13 + r3;
        long r2 = r1 | (r5 << r17);
        r12[r7] = r2 ^ r12[r7];
        r1 = r5 >>> r0;
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    private static int bitLength(long r3) {
        int r0 = 32;
        int r1 = (int) (r3 >>> 32);
        if (r1 != 0) goto L5;
        r1 = (int) r3;
        r0 = 0;
    L5:
        int r4 = r1 >>> 16;
        if (r4 != 0) goto L11;
        int r5 = r1 >>> 8;
        if (r5 != 0) goto L10;
        int r6 = bitLengths[r1];
    L16:
        return r0 + r6;
    L10:
        r6 = bitLengths[r5] + 8;
        goto L16
    L11:
        int r7 = r4 >>> 8;
        if (r7 != 0) goto L14;
        r6 = bitLengths[r4] + 16;
        goto L16
    L14:
        r6 = bitLengths[r7] + 24;
        goto L16
    }

    private int degreeFrom(int r5) {
        int r6 = (r5 + 62) >>> 6;
    L3:
        if (r6 == 0) goto L4;
        r6 = r6 - 1;
        long r0 = this.m_ints[r6];
        if (r0 == 0) goto L3;
        return (r6 << 6) + bitLength(r0);
    L4:
        return 0;
    }

    private static void flipBit(long[] r5, int r6, int r7) {
        int r0 = r7 >>> 6;
        int r8 = r6 + r0;
        long r3 = r5[r8];
        r5[r8] = r3 ^ (1 << (r7 & 63));
    }

    private static void flipVector(long[] r6, int r7, long[] r8, int r9, int r10, int r11) {
        int r12 = r7 + (r11 >>> 6);
        int r13 = r11 & 63;
        if (r13 != 0) goto L5;
        add(r6, r12, r8, r9, r10);
        return;
    L5:
        r6[r12] = addShiftedDown(r6, r12 + 1, r8, r9, r10, 64 - r13) ^ r6[r12];
    }

    private static void flipWord(long[] r4, int r5, int r6, long r7) {
        int r8 = r5 + (r6 >>> 6);
        int r9 = r6 & 63;
        if (r9 != 0) goto L5;
        r4[r8] = r4[r8] ^ r7;
        return;
    L5:
        r4[r8] = r4[r8] ^ (r7 << r9);
        long r10 = r7 >>> (64 - r9);
        if (r10 == 0) goto L10;
        int r11 = r8 + 1;
        r4[r11] = r10 ^ r4[r11];
        return;
    }

    private static long interleave2_32to64(int r6) {
        short[] r0 = INTERLEAVE2_TABLE;
        int r1 = r0[r6 & 255] | (r0[(r6 >>> 8) & 255] << 16);
        short r2 = r0[(r6 >>> 16) & 255];
        long r3 = (((long) ((r0[r6 >>> 24] << 16) | r2)) & 4294967295L) << 32;
        return (((long) r1) & 4294967295L) | r3;
    }

    private static void multiplyWord(long r18, long[] r20, int r21, long[] r22, int r23) {
        if ((r18 & 1) == 0) goto L6;
        add(r22, r23, r20, 0, r21);
    L6:
        long r0 = r18;
        int r15 = 1;
    L7:
        long r16 = r0 >>> 1;
        if (r16 == 0) goto L15;
        if ((r16 & 1) == 0) goto L14;
        long r1 = addShiftedUp(r22, r23, r20, 0, r21, r15);
        if (r1 == 0) goto L14;
        int r2 = r23 + r21;
        r22[r2] = r1 ^ r22[r2];
    L14:
        r15 = r15 + 1;
        r0 = r16;
        goto L7
    }

    private static void reduceBit(long[] r1, int r2, int r3, int r4, int[] r5) {
        flipBit(r1, r2, r3);
        int r6 = r3 - r4;
        int r7 = r5.length;
    L3:
        r7 = r7 - 1;
        if (r7 < 0) goto L6;
        flipBit(r1, r2, r5[r7] + r6);
        goto L3
    L6:
        flipBit(r1, r2, r6);
    }

    private static void reduceBitWise(long[] r1, int r2, int r3, int r4, int[] r5) {
    L2:
        r3 = r3 - 1;
        if (r3 < r4) goto L7;
        if (testBit(r1, r2, r3) == false) goto L2;
        reduceBit(r1, r2, r3, r4, r5);
        goto L2
    }

    private static int reduceInPlace(long[] r14, int r15, int r16, int r17, int[] r18) {
        int r10 = (r17 + 63) >>> 6;
        if (r16 >= r10) goto L5;
        return r16;
    L5:
        int r1 = r16 << 6;
        int r2 = Math.min(r1, (r17 << 1) - 1);
        int r3 = r1 - r2;
        int r11 = r16;
    L7:
        if (r3 < 64) goto L9;
        r11 = r11 - 1;
        r3 = r3 - 64;
        goto L7
    L9:
        int r4 = r18.length;
        int r5 = r18[r4 - 1];
        if (r4 <= 1) goto L12;
        int r6 = r18[r4 - 2];
    L13:
        int r12 = Math.max(r17, r5 + 64);
        int r0 = (r3 + Math.min(r2 - r12, r17 - r6)) >> 6;
        if (r0 <= 1) goto L19;
        int r13 = r11 - r0;
        reduceVectorWise(r14, r15, r11, r13, r17, r18);
    L16:
        if (r11 <= r13) goto L18;
        r11 = r11 - 1;
        r14[r15 + r11] = 0;
        goto L16
    L18:
        r2 = r13 << 6;
    L19:
        if (r2 <= r12) goto L21;
        reduceWordWise(r14, r15, r11, r12, r17, r18);
    L22:
        if (r12 <= r17) goto L24;
        reduceBitWise(r14, r15, r12, r17, r18);
    L24:
        return r10;
    L21:
        r12 = r2;
        goto L22
    L12:
        r6 = 0;
        goto L13
    }

    private static LongArray reduceResult(long[] r0, int r1, int r2, int r3, int[] r4) {
        return new LongArray(r0, r1, reduceInPlace(r0, r1, r2, r3, r4));
    }

    private static void reduceVectorWise(long[] r7, int r8, int r9, int r10, int r11, int[] r12) {
        int r6 = (r10 << 6) - r11;
        int r13 = r12.length;
    L3:
        r13 = r13 - 1;
        if (r13 < 0) goto L6;
        flipVector(r7, r8, r7, r8 + r10, r9 - r10, r6 + r12[r13]);
        goto L3
    L6:
        flipVector(r7, r8, r7, r8 + r10, r9 - r10, r6);
    }

    private static void reduceWord(long[] r1, int r2, int r3, long r4, int r6, int[] r7) {
        int r5 = r3 - r6;
        int r8 = r7.length;
    L3:
        r8 = r8 - 1;
        if (r8 < 0) goto L6;
        flipWord(r1, r2, r7[r8] + r5, r4);
        goto L3
    L6:
        flipWord(r1, r2, r5, r4);
    }

    private static void reduceWordWise(long[] r9, int r10, int r11, int r12, int r13, int[] r14) {
        int r7 = r12 >>> 6;
        int r0 = r11;
    L3:
        int r8 = r0 - 1;
        if (r8 <= r7) goto L9;
        int r2 = r10 + r8;
        long r3 = r9[r2];
        if (r3 == 0) goto L8;
        r9[r2] = 0;
        reduceWord(r9, r10, r8 << 6, r3, r13, r14);
    L8:
        r0 = r8;
        goto L3
    L9:
        int r4 = r12 & 63;
        int r5 = r10 + r7;
        long r6 = r9[r5] >>> r4;
        if (r6 == 0) goto L16;
        r9[r5] = r9[r5] ^ (r6 << r4);
        reduceWord(r9, r10, r12, r6, r13, r14);
        return;
    }

    private long[] resizedInts(int r3) {
        long[] r0 = new long[r3];
        long[] r2 = this.m_ints;
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    private static long shiftUp(long[] r9, int r10, long[] r11, int r12, int r13, int r14) {
        int r0 = 64 - r14;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r13) goto L5;
        long r4 = r9[r10 + r3];
        r11[r12 + r3] = r1 | (r4 << r14);
        r1 = r4 >>> r0;
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    private static void squareInPlace(long[] r4, int r5, int r6, int[] r7) {
        int r8 = r5 << 1;
    L3:
        r5 = r5 - 1;
        if (r5 < 0) goto L6;
        long r0 = r4[r5];
        int r9 = r8 - 1;
        r4[r9] = interleave2_32to64((int) (r0 >>> 32));
        r8 = r9 - 1;
        r4[r8] = interleave2_32to64((int) r0);
        goto L3
    }

    private static boolean testBit(long[] r3, int r4, int r5) {
        int r0 = r5 >>> 6;
        long r6 = r3[r4 + r0];
        if ((r6 & (1 << (r5 & 63))) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public LongArray addOne() {
        if (this.m_ints.length == 0) goto L5;
        long[] r6 = resizedInts(Math.max(1, getUsedLength()));
        r6[0] = r6[0] ^ 1;
        return new LongArray(r6);
    L5:
        return new LongArray(new long[]{1});
    }

    public void addShiftedByWords(LongArray r4, int r5) {
        int r0 = r4.getUsedLength();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = r0 + r5;
        if (r1 <= this.m_ints.length) goto L8;
        this.m_ints = resizedInts(r1);
    L8:
        add(this.m_ints, r5, r4.m_ints, 0, r0);
    }

    public Object clone() {
        return new LongArray(Arrays.clone(this.m_ints));
    }

    void copyTo(long[] r3, int r4) {
        long[] r2 = this.m_ints;
        System.arraycopy(r2, 0, r3, r4, r2.length);
    }

    public int degree() {
        int r0 = this.m_ints.length;
    L3:
        if (r0 == 0) goto L4;
        r0 = r0 - 1;
        long r1 = this.m_ints[r0];
        if (r1 == 0) goto L3;
        return (r0 << 6) + bitLength(r1);
    L4:
        return 0;
    }

    public boolean equals(Object r8) {
        if (ZeusTransformUtils.instanceOf(r8, LongArray.class) == true) goto L5;
        return false;
    L5:
        LongArray r9 = (LongArray) ZeusTransformUtils.preCheckCast(r8, LongArray.class, "com.obric.memorydata.plugin");
        int r0 = getUsedLength();
        if (r9.getUsedLength() == r0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L14;
        if (this.m_ints[r1] != r9.m_ints[r1]) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return false;
    L14:
        return true;
    }

    public int getUsedLength() {
        return getUsedLengthFrom(this.m_ints.length);
    }

    public int getUsedLengthFrom(int r7) {
        long[] r6 = this.m_ints;
        int r8 = Math.min(r7, r6.length);
        if (r8 >= 1) goto L6;
        return 0;
    L6:
        if (r6[0] == 0) goto L12;
    L7:
        r8 = r8 - 1;
        if (r6[r8] == 0) goto L7;
        return r8 + 1;
    L12:
        r8 = r8 - 1;
        if (r6[r8] != 0) goto L15;
        if (r8 > 0) goto L12;
        return 0;
    L15:
        return r8 + 1;
    }

    public int hashCode() {
        int r0 = getUsedLength();
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        long r3 = this.m_ints[r2];
        r1 = (((r1 * 31) ^ ((int) r3)) * 31) ^ ((int) (r3 >>> 32));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public boolean isOne() {
        long[] r7 = this.m_ints;
        if (r7[0] == 1) goto L5;
        return false;
    L5:
        int r2 = 1;
    L7:
        if (r2 >= r7.length) goto L12;
        if (r7[r2] != 0) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public boolean isZero() {
        long[] r6 = this.m_ints;
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L9;
        if (r6[r1] != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public LongArray modInverse(int r11, int[] r12) {
        int r0 = degree();
        if (r0 == 0) goto L21;
        int r1 = 1;
        if (r0 != 1) goto L7;
        return this;
    L7:
        LongArray r10 = (LongArray) ZeusTransformUtils.preCheckCast(clone(), LongArray.class, "com.obric.memorydata.plugin");
        int r2 = (r11 + 63) >>> 6;
        LongArray r3 = new LongArray(r2);
        reduceBit(r3.m_ints, 0, r11, r11, r12);
        LongArray r13 = new LongArray(r2);
        r13.m_ints[0] = 1;
        LongArray r4 = new LongArray(r2);
        int[] r6 = new int[2];
        r6[0] = r0;
        r6[1] = r11 + 1;
        LongArray[] r14 = {r10, r3};
        int[] r15 = {1, 0};
        LongArray[] r5 = {r13, r4};
        int r16 = r6[1];
        int r7 = r15[1];
        int r8 = r16 - r6[0];
    L8:
        if (r8 >= 0) goto L10;
        r8 = -r8;
        r6[r1] = r16;
        r15[r1] = r7;
        int r17 = 1 - r1;
        int r9 = r6[r17];
        r7 = r15[r17];
        r1 = r17;
        r16 = r9;
    L10:
        int r18 = 1 - r1;
        r14[r1].addShiftedByBitsSafe(r14[r18], r6[r18], r8);
        int r19 = r14[r1].degreeFrom(r16);
        if (r19 == 0) goto L13;
        int r20 = r15[r18];
        r5[r1].addShiftedByBitsSafe(r5[r18], r20, r8);
        int r21 = r20 + r8;
        if (r21 <= r7) goto L17;
        r7 = r21;
    L19:
        r8 = r8 + (r19 - r16);
        r16 = r19;
        goto L8
    L17:
        if (r21 != r7) goto L19;
        r7 = r5[r1].degreeFrom(r7);
        goto L19
    L13:
        return r5[r18];
    L21:
        throw new IllegalStateException();
    }

    public LongArray modMultiply(LongArray r24, int r25, int[] r26) {
        int r2 = degree();
        if (r2 != 0) goto L5;
        return this;
    L5:
        int r3 = r24.degree();
        if (r3 != 0) goto L8;
        return r24;
    L8:
        if (r2 <= r3) goto L10;
        int r5 = r2;
        int r4 = r3;
        LongArray r6 = this;
        LongArray r7 = r24;
    L11:
        int r8 = (r4 + 63) >>> 6;
        int r11 = (r5 + 63) >>> 6;
        int r9 = ((r4 + r5) + 62) >>> 6;
        if (r8 != 1) goto L18;
        long r10 = r7.m_ints[0];
        if (r10 != 1) goto L16;
        return r6;
    L16:
        long[] r12 = new long[r9];
        multiplyWord(r10, r6.m_ints, r11, r12, 0);
        return reduceResult(r12, 0, r9, r25, r26);
    L18:
        int r13 = ((r5 + 7) + 63) >>> 6;
        int r14 = 16;
        int[] r15 = new int[16];
        int r16 = r13 << 4;
        long[] r17 = new long[r16];
        r15[1] = r13;
        System.arraycopy(r6.m_ints, 0, r17, r13, r11);
        int r18 = 2;
        int r19 = r13;
    L19:
        if (r18 >= r14) goto L25;
        r19 = r19 + r13;
        r15[r18] = r19;
        if ((r18 & 1) != 0) goto L23;
        long[] r110 = r17;
        shiftUp(r17, r19 >>> 1, r17, r19, r13, 1);
    L24:
        r18 = r18 + 1;
        r16 = r16;
        r17 = r110;
        r14 = 16;
        goto L19
    L23:
        r110 = r17;
        add(r110, r13, r17, r19 - r13, r110, r19, r13);
        goto L24
    L25:
        long[] r111 = r17;
        int r20 = r16;
        long[] r21 = new long[r20];
        shiftUp(r111, 0, r21, 0, r20, 4);
        long[] r22 = r7.m_ints;
        int r23 = r9 << 3;
        long[] r27 = new long[r23];
        int r112 = 0;
    L26:
        if (r112 >= r8) goto L32;
        long r113 = r22[r112];
        int r114 = r112;
    L28:
        int r115 = ((int) r113) & 15;
        long r116 = r113 >>> 4;
        int r28 = r112;
        addBoth(r27, r114, r111, r15[r115], r21, r15[((int) r116) & 15], r13);
        r113 = r116 >>> 4;
        if (r113 == 0) goto L30;
        r114 = r114 + r9;
        r112 = r28;
        goto L28
    L30:
        r112 = r28 + 1;
    L32:
        r23 = r23 - r9;
        if (r23 == 0) goto L36;
        addShiftedUp(r27, r23 - r9, r27, r23, r9, 8);
        goto L32
    L36:
        return reduceResult(r27, 0, r9, r25, r26);
    L10:
        r4 = r2;
        r5 = r3;
        r7 = this;
        r6 = r24;
        goto L11
    }

    public LongArray modSquare(int r10, int[] r11) {
        int r0 = getUsedLength();
        if (r0 != 0) goto L5;
        return this;
    L5:
        int r1 = r0 << 1;
        long[] r2 = new long[r1];
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L9;
        long r4 = this.m_ints[r3 >>> 1];
        int r6 = r3 + 1;
        r2[r3] = interleave2_32to64((int) r4);
        r3 = r6 + 1;
        r2[r6] = interleave2_32to64((int) (r4 >>> 32));
        goto L6
    L9:
        return new LongArray(r2, 0, reduceInPlace(r2, 0, r1, r10, r11));
    }

    public LongArray modSquareN(int r5, int r6, int[] r7) {
        int r0 = getUsedLength();
        if (r0 != 0) goto L5;
        return this;
    L5:
        int r1 = ((r6 + 63) >>> 6) << 1;
        long[] r2 = new long[r1];
        System.arraycopy(this.m_ints, 0, r2, 0, r0);
    L6:
        r5 = r5 - 1;
        if (r5 < 0) goto L10;
        squareInPlace(r2, r0, r6, r7);
        r0 = reduceInPlace(r2, 0, r1, r6, r7);
        goto L6
    L10:
        return new LongArray(r2, 0, r0);
    }

    public LongArray multiply(LongArray r23, int r24, int[] r25) {
        int r0 = degree();
        if (r0 != 0) goto L5;
        return this;
    L5:
        int r1 = r23.degree();
        if (r1 != 0) goto L8;
        return r23;
    L8:
        if (r0 <= r1) goto L10;
        int r3 = r0;
        int r2 = r1;
        LongArray r4 = this;
        LongArray r5 = r23;
    L11:
        int r6 = (r2 + 63) >>> 6;
        int r9 = (r3 + 63) >>> 6;
        int r7 = ((r2 + r3) + 62) >>> 6;
        if (r6 != 1) goto L18;
        long r8 = r5.m_ints[0];
        if (r8 != 1) goto L16;
        return r4;
    L16:
        long[] r10 = new long[r7];
        multiplyWord(r8, r4.m_ints, r9, r10, 0);
        return new LongArray(r10, 0, r7);
    L18:
        int r11 = ((r3 + 7) + 63) >>> 6;
        int r12 = 16;
        int[] r13 = new int[16];
        int r15 = r11 << 4;
        long[] r14 = new long[r15];
        r13[1] = r11;
        System.arraycopy(r4.m_ints, 0, r14, r11, r9);
        int r16 = 2;
        int r17 = r11;
    L19:
        if (r16 >= r12) goto L25;
        r17 = r17 + r11;
        r13[r16] = r17;
        if ((r16 & 1) != 0) goto L23;
        long[] r18 = r14;
        shiftUp(r14, r17 >>> 1, r14, r17, r11, 1);
    L24:
        r16 = r16 + 1;
        r15 = r15;
        r14 = r18;
        r12 = 16;
        goto L19
    L23:
        r18 = r14;
        add(r18, r11, r18, r17 - r11, r14, r17, r11);
        goto L24
    L25:
        long[] r19 = r14;
        int r20 = r15;
        long[] r21 = new long[r20];
        shiftUp(r19, 0, r21, 0, r20, 4);
        long[] r22 = r5.m_ints;
        int r26 = r7 << 3;
        long[] r27 = new long[r26];
        int r28 = 0;
    L26:
        if (r28 >= r6) goto L32;
        long r110 = r22[r28];
        int r111 = r28;
    L28:
        long r112 = r110 >>> 4;
        int r113 = r111;
        addBoth(r27, r113, r19, r13[((int) r110) & 15], r21, r13[((int) r112) & 15], r11);
        r110 = r112 >>> 4;
        if (r110 == 0) goto L30;
        r111 = r111 + r7;
        goto L28
    L30:
        r28 = r28 + 1;
    L32:
        r26 = r26 - r7;
        if (r26 == 0) goto L36;
        addShiftedUp(r27, r26 - r7, r27, r26, r7, 8);
        goto L32
    L36:
        return new LongArray(r27, 0, r7);
    L10:
        r2 = r0;
        r3 = r1;
        r5 = this;
        r4 = r23;
        goto L11
    }

    public void reduce(int r4, int[] r5) {
        long[] r0 = this.m_ints;
        int r6 = reduceInPlace(r0, 0, r0.length, r4, r5);
        if (r6 >= r0.length) goto L6;
        long[] r7 = new long[r6];
        this.m_ints = r7;
        System.arraycopy(r0, 0, r7, 0, r6);
        return;
    }

    public LongArray square(int r8, int[] r9) {
        int r10 = getUsedLength();
        if (r10 != 0) goto L5;
        return this;
    L5:
        int r11 = r10 << 1;
        long[] r12 = new long[r11];
        int r1 = 0;
    L6:
        if (r1 >= r11) goto L9;
        long r2 = this.m_ints[r1 >>> 1];
        int r4 = r1 + 1;
        r12[r1] = interleave2_32to64((int) r2);
        r1 = r4 + 1;
        r12[r4] = interleave2_32to64((int) (r2 >>> 32));
        goto L6
    L9:
        return new LongArray(r12, 0, r11);
    }

    public boolean testBitZero() {
        long[] r6 = this.m_ints;
        if (r6.length > 0) goto L5;
        return false;
    L5:
        if ((r6[0] & 1) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public BigInteger toBigInteger() {
        int r0 = getUsedLength();
        if (r0 == 0) goto L5;
        int r2 = r0 - 1;
        long r3 = this.m_ints[r2];
        byte[] r5 = new byte[8];
        int r7 = 0;
        int r8 = 7;
        int r9 = 0;
        boolean r10 = false;
    L8:
        if (r8 < 0) goto L14;
        byte r12 = (byte) (r3 >>> (r8 * 8));
        if (r10 == true) goto L12;
        if (r12 != 0) goto L12;
    L13:
        r8 = r8 - 1;
    L12:
        r5[r9] = r12;
        r9 = r9 + 1;
        r10 = true;
        goto L13
    L14:
        byte[] r1 = new byte[(r2 * 8) + r9];
    L15:
        if (r7 >= r9) goto L17;
        r1[r7] = r5[r7];
        r7 = r7 + 1;
        goto L15
    L17:
        int r4 = r0 - 2;
    L18:
        if (r4 < 0) goto L24;
        long r6 = this.m_ints[r4];
        int r11 = 7;
    L20:
        if (r11 < 0) goto L22;
        r1[r9] = (byte) (r6 >>> (r11 * 8));
        r11 = r11 - 1;
        r9 = r9 + 1;
        goto L20
    L22:
        r4 = r4 - 1;
        goto L18
    L24:
        return new BigInteger(1, r1);
    L5:
        return ECConstants.ZERO;
    }

    public String toString() {
        int r0 = getUsedLength();
        if (r0 != 0) goto L6;
        return "0";
    L6:
        int r1 = r0 - 1;
        StringBuffer r2 = new StringBuffer(Long.toBinaryString(this.m_ints[r1]));
    L7:
        r1 = r1 - 1;
        if (r1 < 0) goto L14;
        String r3 = Long.toBinaryString(this.m_ints[r1]);
        int r4 = r3.length();
        if (r4 >= 64) goto L12;
        r2.append("0000000000000000000000000000000000000000000000000000000000000000".substring(r4));
    L12:
        r2.append(r3);
        goto L7
    L14:
        return r2.toString();
    }
}
